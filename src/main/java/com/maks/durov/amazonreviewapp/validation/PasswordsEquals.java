package com.maks.durov.amazonreviewapp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = PasswordsEqualsValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsEquals {

    String message() default "password and repeat password should be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
