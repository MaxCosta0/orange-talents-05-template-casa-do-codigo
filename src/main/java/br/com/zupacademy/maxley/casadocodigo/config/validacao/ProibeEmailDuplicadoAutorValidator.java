package br.com.zupacademy.maxley.casadocodigo.config.validacao;

import br.com.zupacademy.maxley.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.maxley.casadocodigo.model.Autor;
import br.com.zupacademy.maxley.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorForm request = (AutorForm) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "Ja existe um autor(a) com este email.");
        }
        return;
    }
}
