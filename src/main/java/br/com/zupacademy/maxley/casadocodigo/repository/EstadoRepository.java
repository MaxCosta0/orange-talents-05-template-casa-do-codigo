package br.com.zupacademy.maxley.casadocodigo.repository;

import br.com.zupacademy.maxley.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findAllByNome(String nome);
}
