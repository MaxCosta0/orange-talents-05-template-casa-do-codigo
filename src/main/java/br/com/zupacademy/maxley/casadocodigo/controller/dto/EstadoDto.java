package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.ExistsId;
import br.com.zupacademy.maxley.casadocodigo.model.Estado;
import br.com.zupacademy.maxley.casadocodigo.model.Pais;
import br.com.zupacademy.maxley.casadocodigo.repository.PaisRespository;
import org.springframework.util.Assert;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoDto {

    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;


    public EstadoDto(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado converter(PaisRespository paisRespository){
        Optional<Pais> pais = paisRespository.findById(this.paisId);
        Assert.state(pais.isPresent(), "Pais nao cadastrado no sistema");
        return new Estado(this.nome, pais.get());
    }

    public String getNome() {
        return this.nome;
    }

    public Long getPaisId() {
        return this.paisId;
    }
}
