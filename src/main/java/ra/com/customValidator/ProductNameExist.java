package ra.com.customValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidateProductName.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ProductNameExist {
    String message() default "Product name is not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
