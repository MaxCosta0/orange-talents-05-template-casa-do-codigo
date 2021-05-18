package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.UniqueValue;
import br.com.zupacademy.maxley.casadocodigo.model.Categoria;

import javax.validation.constraints.NotEmpty;

public class CategoriaDto {

    @NotEmpty
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public Categoria converter(CategoriaDto categoriaDto){
        return new Categoria(categoriaDto.nome);
    }
}
