package ra.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import ra.com.model.DTO.req.ProductReqUpdate;
import ra.com.model.Product;
import ra.com.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadService uploadService;

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    public boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public ProductReqUpdate convertProductToProductReqUpdate(Long id) {
       Product product = productRepository.findProductById(id);
       return  ProductReqUpdate.builder()
               .productName(product.getProductName())
               .price(product.getPrice())
               .stock(product.getStock())
               .status(product.isStatus())
               .build();


    }
     public Product findProductById(Long id) {
        return productRepository.findProductById(id);
     }

    public boolean updateProduct(ProductReqUpdate productReqUpdate, Errors errors) {
        boolean isExist = productRepository.checkExistProductNameUpdate(productReqUpdate.getProductName(),productReqUpdate.getId());
       if(isExist){
           errors.rejectValue("productName","duplicate","Tên sản phẩm đã tồn tại");
           return false;
       }
       String imageUrlUpdate;
       if(productReqUpdate.getImageUrl()!=null && !productReqUpdate.getImageUrl().isEmpty()){
           imageUrlUpdate = uploadService.uploadFile(productReqUpdate.getImageUrl());
       }else {
           imageUrlUpdate = productReqUpdate.getOldImageUrl();
       }
       Product product = new Product(
               productReqUpdate.getId(),
               productReqUpdate.getProductName(),
               productReqUpdate.getPrice(),
               productReqUpdate.getStock(),
               imageUrlUpdate,
               productReqUpdate.isStatus()
       );
       return productRepository.updateProduct(product);
    }

    public boolean deleteProductById(Long id) {
        return productRepository.deleteProductById(id);
    }

}
