package ra.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.User;
import ra.com.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceIpm implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean delete(long id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String userName, String password) {
        return userRepository.login(userName, password);
    }
}
