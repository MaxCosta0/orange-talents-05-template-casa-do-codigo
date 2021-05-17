package br.com.zupacademy.maxley.casadocodigo.controller.form;

import br.com.zupacademy.maxley.casadocodigo.model.Autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty @Size(max=400)
    private String descricao;

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
