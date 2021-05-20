package br.com.zupacademy.maxley.casadocodigo.controller;

import br.com.zupacademy.maxley.casadocodigo.config.validacao.ProibeEstadoComNomesIguaisParaMesmoPaisValidator;
import br.com.zupacademy.maxley.casadocodigo.controller.dto.EstadoDto;
import br.com.zupacademy.maxley.casadocodigo.model.Estado;
import br.com.zupacademy.maxley.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.PaisRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRespository paisRespository;

    @Autowired
    private ProibeEstadoComNomesIguaisParaMesmoPaisValidator proibeEstadoComNomesIguaisParaMesmoPaisValidator;

    @InitBinder
    private void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoComNomesIguaisParaMesmoPaisValidator);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoDto estadoDto){
        Estado estado = estadoDto.converter(paisRespository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().build();
    }
}
