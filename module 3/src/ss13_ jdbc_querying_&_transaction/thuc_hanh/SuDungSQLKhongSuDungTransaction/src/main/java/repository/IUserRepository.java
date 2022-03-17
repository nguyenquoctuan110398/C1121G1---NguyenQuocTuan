package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLException;

    User selectUser(Integer id);
    
    List<User> selectAllUsers();

    boolean deleteUser(Integer id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    public void insertUpdateWithoutTransaction();
}
