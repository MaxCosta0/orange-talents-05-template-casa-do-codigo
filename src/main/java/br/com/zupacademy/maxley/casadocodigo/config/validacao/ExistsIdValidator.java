package br.com.zupacademy.maxley.casadocodigo.config.validacao;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.ExistsId;

import br.com.zupacademy.maxley.casadocodigo.model.Autor;
import br.com.zupacademy.maxley.casadocodigo.model.Categoria;
import br.com.zupacademy.maxley.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    private String domainAttribute;
    private Class<?> klass;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(ExistsId params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Long id = (Long) value;

        /*
        * Solução improvisada, pois utilizando o EntityManager nao estava conseguindo gerar um
        * MethodArgumentNotValidException, apenas um IllegalStateException. Estava dando um erro dentro
        * da isValid que eu nao estava entendendo.
        */
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        Optional<Autor> autor = autorRepository.findById(id);

        return (categoria.isPresent() && autor.isPresent());
    }
}
