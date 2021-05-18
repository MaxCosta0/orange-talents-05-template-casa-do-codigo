package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.UniqueValue;
import br.com.zupacademy.maxley.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorDto {

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotNull @NotEmpty @Size(max=400)
    private String descricao;

    @Deprecated
    public AutorDto(){}

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter(AutorDto autorDto) {
        return new Autor(autorDto.getNome(), autorDto.getEmail(), autorDto.getDescricao());
    }
}
