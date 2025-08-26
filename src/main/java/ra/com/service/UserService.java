package ra.com.service;

import ra.com.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    boolean update(User user);

    boolean delete(long id);

    boolean addUser(User user);

    User login(String userName, String password);
}
