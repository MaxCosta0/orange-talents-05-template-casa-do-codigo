package br.com.zupacademy.maxley.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Deprecated
    public Pais(){}

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }
}
