package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.ExistsId;
import br.com.zupacademy.maxley.casadocodigo.config.annotation.UniqueValue;
import br.com.zupacademy.maxley.casadocodigo.model.Autor;
import br.com.zupacademy.maxley.casadocodigo.model.Categoria;
import br.com.zupacademy.maxley.casadocodigo.model.Livro;
import br.com.zupacademy.maxley.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroDto {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotNull
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    @Deprecated
    public LivroDto(){}

    public LivroDto(String titulo, String resumo, String sumario,
                    BigDecimal preco, Integer numeroPaginas, String isbn,
                    LocalDate dataPublicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        Optional<Categoria> categoria = categoriaRepository.findById(this.categoriaId);
        Optional<Autor> autor = autorRepository.findById(this.autorId);

        Assert.state(categoria.isPresent(), "Esta categoria nao esta cadastrada");
        Assert.state(autor.isPresent(), "Este autor nao esta cadastrado");

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas,
                this.isbn, this.dataPublicacao, categoria.get(), autor.get());
    }
}
