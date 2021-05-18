package br.com.zupacademy.maxley.casadocodigo.controller;

import br.com.zupacademy.maxley.casadocodigo.config.validacao.ProibeNomeCategoriaDuplicadoValidator;
import br.com.zupacademy.maxley.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.maxley.casadocodigo.model.Categoria;
import br.com.zupacademy.maxley.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProibeNomeCategoriaDuplicadoValidator proibeNomeCategoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeCategoriaDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaDto categoriaDto){
        Categoria categoria = categoriaDto.converter(categoriaDto);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}