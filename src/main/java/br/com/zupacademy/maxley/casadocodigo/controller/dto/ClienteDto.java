package br.com.zupacademy.maxley.casadocodigo.controller.dto;

import br.com.zupacademy.maxley.casadocodigo.config.annotation.UniqueValue;
import br.com.zupacademy.maxley.casadocodigo.model.Cliente;
import br.com.zupacademy.maxley.casadocodigo.model.Estado;
import br.com.zupacademy.maxley.casadocodigo.model.Pais;
import br.com.zupacademy.maxley.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.PaisRespository;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteDto {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @CPF
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long paisId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    private Long estadoId;

    @Deprecated
    public ClienteDto(){}

    public ClienteDto(String email, String nome, String sobrenome,
                      String documento, String endereco, String complemento,
                      String cidade, Long paisId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente converter(PaisRespository paisRespository, EstadoRepository estadoRepository){
        Optional<Pais> pais = paisRespository.findById(paisId);
        Assert.state(pais.isPresent(), "Este pais nao esta cadastrado.");

        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome,
                this.documento, this.endereco, this.complemento,
                this.cidade, pais.get(), this.telefone, this.cep);

        if(estadoId != null) {
            Optional<Estado> estado = estadoRepository.findById(estadoId);
            Assert.state(estado.isPresent(), "Este estado no esta cadastrado.");
            cliente.setEstado(estado.get());
        }
        return cliente;
    }
}

/*
* Select 1 from estado.get() where paisId = :pvalue
* */