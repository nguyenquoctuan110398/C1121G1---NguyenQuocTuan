package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    User findById(Integer id);

    boolean update(User user);

    boolean deleteUser(Integer id);

    List<User> searchByCountry(String countrySearch);

    List<User> sortByName();

    void addUserTransaction(User user, int[] permision);
}
