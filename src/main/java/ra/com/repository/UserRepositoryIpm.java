package ra.com.repository;

import org.springframework.stereotype.Repository;
import ra.com.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryIpm implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> findAll() {
       return  entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.createQuery("from User where id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(User user) {
        try {
            entityManager.persist(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
       try {
           entityManager.remove(findById(id));
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    @Transactional
    public boolean update(User user) {
        try {
            entityManager.merge(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean checkExistUsername(String userName) {
        Long count = entityManager.createQuery("select count(id) from User where userName = :userName", Long.class)
                .setParameter("userName", userName)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public User login(String userName, String password) {
        try {
            User user = (User) entityManager.createQuery("from User where userName = :userName and password = :password", User.class)
                    .setParameter("userName", userName)
                    .setParameter("password", password)
                    .getSingleResult();
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
