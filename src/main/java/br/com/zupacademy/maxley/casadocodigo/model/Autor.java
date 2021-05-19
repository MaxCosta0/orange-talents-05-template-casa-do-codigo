package br.com.zupacademy.maxley.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty @Size(max=400)
    private String descricao;

    private LocalDateTime dataCriacao;

    @Deprecated
    public Autor(){}

    public Autor(String nome, String email, String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
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

    public Long getId() {
        return this.id;
    }
}
