package service;

import model.User;

import java.util.List;

public interface IUserService {
    void insertUser(User user);
    User selectUserById(Integer id);
    List<User> selectAllUser();
    boolean deleteUserById(Integer id);
    boolean updateUser(User user);
    List<User> searchByCountry(String country);
    List<User> sortByName();

    List<User> sPSelectAllUsers();
    boolean sPUpdateUserById(User user);
    boolean sPDeleteUserById(Integer id);

}
