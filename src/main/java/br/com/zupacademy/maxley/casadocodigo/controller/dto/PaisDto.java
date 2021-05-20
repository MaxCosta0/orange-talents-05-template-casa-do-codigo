package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.UniqueValue;
import br.com.zupacademy.maxley.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisDto {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisDto(){}

    public PaisDto(String nome) {
        this.nome = nome;
    }

    /*
    * Este set esta aqui porque caso contrario na hora de cadastrar um pais
    * o campo nome fica em branco.
    */
    public void setNome(String nome){
        this.nome = nome;
    }

    public Pais converter() {
        return new Pais(this.nome);
    }
}
