package ra.com.customValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.com.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidatorUsername implements ConstraintValidator<UsernameExist,String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String userName,  ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.checkExistUsername(userName);
    }
}
