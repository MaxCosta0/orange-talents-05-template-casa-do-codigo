package br.com.zupacademy.maxley.casadocodigo.controller;

import br.com.zupacademy.maxley.casadocodigo.config.validacao.ProibeEstadoQueNaoEstaVinculadoAoPais;
import br.com.zupacademy.maxley.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.maxley.casadocodigo.model.Cliente;
import br.com.zupacademy.maxley.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.maxley.casadocodigo.repository.PaisRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ProibeEstadoQueNaoEstaVinculadoAoPais proibeEstadoQueNaoEstaVinculadoAoPais;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRespository paisRespository;

    @Autowired
    private EstadoRepository estadoRepository;

    @InitBinder
    private void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoQueNaoEstaVinculadoAoPais);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid ClienteDto clienteDto){
        Cliente cliente = clienteDto.converter(paisRespository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
}
