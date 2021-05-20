package br.com.zupacademy.maxley.casadocodigo.controller;

import br.com.zupacademy.maxley.casadocodigo.controller.dto.PaisDto;
import br.com.zupacademy.maxley.casadocodigo.model.Pais;
import br.com.zupacademy.maxley.casadocodigo.repository.PaisRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRespository paisRespository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisDto paisDto){
        Pais pais = paisDto.converter();
        paisRespository.save(pais);
        return ResponseEntity.ok().build();
    }
}
