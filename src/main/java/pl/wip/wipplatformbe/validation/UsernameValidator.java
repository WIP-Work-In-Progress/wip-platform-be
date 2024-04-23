package pl.wip.wipplatformbe.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.wip.wipplatformbe.services.UserService;

public class UsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null)
            return true;
        
        return !userService.usernameExists(username);
    }
}
