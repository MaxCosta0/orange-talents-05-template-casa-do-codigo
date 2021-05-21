package br.com.zupacademy.maxley.casadocodigo.repository;

import br.com.zupacademy.maxley.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
