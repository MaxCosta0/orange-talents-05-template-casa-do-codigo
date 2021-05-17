package br.com.zupacademy.maxley.casadocodigo.controller;

import br.com.zupacademy.maxley.casadocodigo.config.validacao.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.maxley.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.maxley.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.maxley.casadocodigo.model.Autor;
import br.com.zupacademy.maxley.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form){
        Autor autor = form.converterAutorFormParaAutor(form);
        autorRepository.save(autor);
        AutorDto autorDto = new AutorDto(autor);

        return ResponseEntity.ok(autorDto);
    }
}
