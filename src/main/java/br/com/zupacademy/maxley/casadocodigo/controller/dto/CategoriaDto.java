package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.model.Categoria;

import javax.validation.constraints.NotEmpty;

public class CategoriaDto {

    @NotEmpty
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public Categoria converter(CategoriaDto categoriaDto){
        return new Categoria(categoriaDto.nome);
    }
}
