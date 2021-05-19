package br.com.zupacademy.maxley.casadocodigo.controller;

import br.com.zupacademy.maxley.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.maxley.casadocodigo.model.Autor;
import br.com.zupacademy.maxley.casadocodigo.model.Categoria;
import br.com.zupacademy.maxley.casadocodigo.model.Livro;
import br.com.zupacademy.maxley.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroDto livroDto){
        Livro livro = livroDto.converter(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }
}
