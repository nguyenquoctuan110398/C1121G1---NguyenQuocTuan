package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return iUserRepository.findById(id);
    }

    @Override
    public boolean update(User user) {
        return iUserRepository.update(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return iUserRepository.deleteUser(id);
    }

    @Override
    public List<User> searchByCountry(String countrySearch) {
        return iUserRepository.searchByCountry(countrySearch);

    }

    @Override
    public List<User> sortByName() {
        return iUserRepository.sortByName();
    }
}
