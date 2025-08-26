package ra.com.repository;

import ra.com.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(Long id);

    boolean save(User user);

    boolean delete(Long id);

    boolean update(User user);

    boolean checkExistUsername(String userName);

     User login(String userName, String password);
}
