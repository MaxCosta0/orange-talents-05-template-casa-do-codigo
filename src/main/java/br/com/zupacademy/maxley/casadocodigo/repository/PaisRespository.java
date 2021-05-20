package br.com.zupacademy.maxley.casadocodigo.repository;

import br.com.zupacademy.maxley.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRespository extends JpaRepository<Pais, Long> {
}
