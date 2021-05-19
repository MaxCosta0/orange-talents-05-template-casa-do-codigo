package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.model.Autor;
import br.com.zupacademy.maxley.casadocodigo.model.Livro;
import br.com.zupacademy.maxley.casadocodigo.repository.AutorRepository;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Optional;

public class LivroDetalhes {

    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private Integer numeroPaginas;
    private String isbn;
    private String nomeAutor;
    private String descricaoAutor;

    @Deprecated
    public LivroDetalhes(){}

    public LivroDetalhes(String titulo, BigDecimal preco, String resumo,
                         String sumario, Integer numeroPaginas, String isbn,
                         String nomeAutor, String descricaoAutor) {
        this.titulo = titulo;
        this.preco = preco;
        this.resumo = resumo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.nomeAutor = nomeAutor;
        this.descricaoAutor = descricaoAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }

    public static LivroDetalhes converter(AutorRepository autorRepository, Livro livro){
        Optional<Autor> autor = autorRepository.findById(livro.getIdAutor());

        Assert.state(autor.isPresent(), "Autor nao cadastrado no banco");

        return new LivroDetalhes(livro.getTitulo(), livro.getPreco(),
                livro.getResumo(), livro.getSumario(),
                livro.getNumeroPaginas(), livro.getIsbn(),
                autor.get().getNome(), autor.get().getDescricao());

    }
}