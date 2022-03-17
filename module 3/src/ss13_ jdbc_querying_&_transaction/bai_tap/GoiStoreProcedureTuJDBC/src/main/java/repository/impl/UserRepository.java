package repository.impl;

import repository.IUserRepository;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";

    private static final String INSERT_USERS_SQL = "insert into users(`name`,email,country) values(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,`name`,email,country from users where id = ? ;";
    private static final String SELECT_ALL_USERS = "select * from users ;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ? ;";
    private static final String UPDATE_USERS_SQL = "update users set `name`= ? , email = ? , country = ? where id = ? ;";
    private static final String SEARCH_BY_COUNTRY = "select id , `name` , email , country from users where country = ? ;";
    private static final String ORDER_BY_NAME = "select id , `name` , email , country from users order by `name` ;";

    private static final String CALL_SP_SELECT_ALL = " { call select_all_users() } ";
    private static final String CALL_SP_UPDATE_USER_BY_ID = " { call update_user (?,?,?,?) } ";
    private static final String CALL_SP_DELETE_USER_BY_ID = " { call delete_user_by_id (?) } ";

    public UserRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public User selectUser(Integer id) {
        Connection connection = null;
        User user = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                User user = new User(id, name, email, country);
                users.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public boolean deleteUser(Integer id) {
        Connection connection = null;
        boolean rowDeleted = false;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        Connection connection = null;
        boolean updated = false;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updated;
    }

    @Override
    public List<User> sortByName() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ORDER_BY_NAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public List<User> sPSelectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(CALL_SP_SELECT_ALL);)
        {
           ResultSet rs = callableStatement.executeQuery();

           while (rs.next()){
               User user = new User();
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
               user.setEmail(rs.getString("email"));
               user.setCountry(rs.getString("country"));
               users.add(user);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean sPUpdateUserById(User user) {
        boolean check = false ;
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(CALL_SP_UPDATE_USER_BY_ID);
        )
        {
            callableStatement.setInt(1,user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());
            check = callableStatement.executeUpdate() > 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean sPDeleteUserById(Integer id) {
        boolean check = false ;

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(CALL_SP_DELETE_USER_BY_ID);
        )
        {
            callableStatement.setInt(1,id);
           check = callableStatement.executeUpdate() > 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();

                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<User> searchByCountry(String country) {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_COUNTRY);
            preparedStatement.setString(1, country);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }
}
