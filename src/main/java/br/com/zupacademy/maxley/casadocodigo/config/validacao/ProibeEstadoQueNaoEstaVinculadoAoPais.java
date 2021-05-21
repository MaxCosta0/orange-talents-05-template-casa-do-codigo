package br.com.zupacademy.maxley.casadocodigo.config.validacao;

import br.com.zupacademy.maxley.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.maxley.casadocodigo.model.Estado;
import br.com.zupacademy.maxley.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEstadoQueNaoEstaVinculadoAoPais implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClienteDto clienteDto = (ClienteDto) target;

        if(clienteDto.getEstadoId() == null){
            return;
        }

        Optional<Estado> estado = estadoRepository.findById(clienteDto.getEstadoId());

        if(estado.isEmpty() || estado.get().getPaisId() != clienteDto.getPaisId()){
            errors.rejectValue("estadoId", null, "Este estado nao pertence ao pais de id = " + clienteDto.getPaisId());
        }

        return;
    }
}
