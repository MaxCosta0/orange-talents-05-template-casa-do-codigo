package br.com.zupacademy.maxley.casadocodigo.config.validacao;

import br.com.zupacademy.maxley.casadocodigo.controller.dto.EstadoDto;
import br.com.zupacademy.maxley.casadocodigo.model.Estado;
import br.com.zupacademy.maxley.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ProibeEstadoComNomesIguaisParaMesmoPaisValidator implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        EstadoDto estadoDto = (EstadoDto) target;

        List<Estado> estados = estadoRepository.findAllByNome(estadoDto.getNome());

        for(Estado estado: estados){
            System.out.println(estado);
        }

        for(Estado estado: estados){
            if(estadoDto.getPaisId() == estado.getPaisId()){
                errors.rejectValue("nome", null, "Ja existe um estado cadastrado com esse nome para esse país.");
            }
        }
    }
}
