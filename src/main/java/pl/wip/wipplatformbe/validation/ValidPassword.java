package pl.wip.wipplatformbe.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
public @interface ValidPassword {
    String message() default "Password must contain at least one lowercase, one uppercase, " +
            "one number and one special character. It must also be at least 6 characters long.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}