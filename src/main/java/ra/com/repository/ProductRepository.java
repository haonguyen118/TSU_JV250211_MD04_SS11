package ra.com.repository;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import ra.com.model.DTO.req.ProductReqUpdate;
import ra.com.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean checkExistProductName(String productName) {
        Long count = entityManager.createQuery("select count(id) from Product where productName = :ProductName", Long.class)
                .setParameter("ProductName", productName).getSingleResult();
        return count > 0;
    }

    public boolean checkExistProductNameUpdate(String productName, Long id) {
        Long count = entityManager.createQuery("select count(id) from Product where productName = :ProductName and id != :id", Long.class)
                .setParameter("ProductName", productName)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }

    public List<Product> findAllProducts() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Transactional
    public boolean addProduct(Product product) {
        try {
            entityManager.persist(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkProductNameExistUpdate(String productName, Long id) {
        Long count = entityManager.createQuery("select count(id) from Product where productName = :productName and id != :id", Long.class)
                .setParameter("productName", productName)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }

    @Transactional
    public boolean updateProduct(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Product findProductById(Long id) {
        return entityManager.createQuery("from Product where id = :id", Product.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    public boolean deleteProductById(Long id) {
        try {
            entityManager.remove(findProductById(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
