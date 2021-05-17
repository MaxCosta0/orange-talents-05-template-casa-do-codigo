package br.com.zupacademy.maxley.casadocodigo.controller.form;

import br.com.zupacademy.maxley.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotEmpty
    private String nome;

    @NotEmpty @Email
    private String email;

    @NotEmpty @Size(max=400)
    private String descricao;

    public AutorForm(){}

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor converterAutorFormParaAutor(AutorForm form){
        return new Autor(form.getNome(), form.getEmail(), form.getDescricao());
    }
}
