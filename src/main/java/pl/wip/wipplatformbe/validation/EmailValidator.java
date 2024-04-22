package pl.wip.wipplatformbe.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wip.wipplatformbe.services.UserService;

public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    public EmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null)
            return true;

        return !userService.emailExists(email);
    }
}
