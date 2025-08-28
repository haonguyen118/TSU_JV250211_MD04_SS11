package ra.com.customValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.com.repository.ProductRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidateProductName implements ConstraintValidator<ProductNameExist, String> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public boolean isValid(String productName, ConstraintValidatorContext contraintValidatorContext) {
        return !productRepository.checkExistProductName(productName);
    }

}
