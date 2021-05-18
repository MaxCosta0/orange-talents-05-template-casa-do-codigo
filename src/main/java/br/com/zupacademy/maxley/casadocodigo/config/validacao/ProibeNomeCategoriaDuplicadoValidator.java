package br.com.zupacademy.maxley.casadocodigo.config.validacao;

import br.com.zupacademy.maxley.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.maxley.casadocodigo.model.Categoria;
import br.com.zupacademy.maxley.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaDto categoria = (CategoriaDto) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoria.getNome());
        if(possivelCategoria.isPresent()){
            errors.rejectValue("nome", null, "Esta categoria ja esta cadastrada.");
        }
        return;
    }
}
