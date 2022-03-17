package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLException;
    User selectUser(Integer id);
    List<User> selectAllUser();
    boolean deleteUser(Integer id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> sortByName();

    List<User> sPSelectAllUsers();

    boolean sPUpdateUserById(User user);

    boolean sPDeleteUserById(Integer id);
}
