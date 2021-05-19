package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroResposta {

    private Long id;

    private String titulo;

    @Deprecated
    public LivroResposta(){}

    public LivroResposta(Long id, String nome){
        this.id = id;
        this.titulo = nome;
    }

    public static List<LivroResposta> converter(List<Livro> livros) {
        List<LivroResposta> livrosResposta = new ArrayList<>();

        for(Livro livro: livros){
            LivroResposta livroResposta = new LivroResposta(livro.getId(), livro.getNome());
            livrosResposta.add(livroResposta);
        }

        return livrosResposta;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
