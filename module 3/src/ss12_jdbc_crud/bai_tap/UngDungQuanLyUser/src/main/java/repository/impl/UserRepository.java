package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {


    private static List<User> userList = new ArrayList<>();

    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id=?";
    private static final String UPDATE_USERS_SQL = "update users set name=?,email=?,country=? where id=?";
    private static final String DELETE_USER_SQL = "delete from users where id=?";
    private static final String SEARCH_USERS_BY_COUNTRY = "select id, name, email, country from users where country like concat('%', ?, '%')";
    BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name, email, country from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
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
        return userList;
    }

    @Override
    public void save(User user) {
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into users(id, name, email, country) values (?,?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User findById(Integer id) {
        User user = null;

        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                user = new User(id, name, email, country);
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
        return user;
    }

    @Override
    public boolean update(User user) {
        Connection connection = baseRepository.getConnection();

        boolean rowUpdated = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

//            rowUpdated = preparedStatement.executeUpdate() > 0;
//            rowUpdated =  true;
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteUser(Integer id) {
        boolean rowDelete = false;
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);

            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDelete;
    }

    @Override
    public List<User> searchByCountry(String countrySearch) {
        Connection connection = baseRepository.getConnection();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_COUNTRY);
            preparedStatement.setString(1, countrySearch);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                userList.add(new User(id, name, email, country));
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

        return userList;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name, email, country from users order by name asc");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
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
        return userList;
    }
}
