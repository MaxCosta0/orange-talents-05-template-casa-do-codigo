package br.com.zupacademy.maxley.casadocodigo.config.annotation;

import br.com.zupacademy.maxley.casadocodigo.config.validacao.UniqueValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {
    String message() default "Ja existe um registro com este valor cadastrado.";
    Class<?> [] groups() default { };
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
