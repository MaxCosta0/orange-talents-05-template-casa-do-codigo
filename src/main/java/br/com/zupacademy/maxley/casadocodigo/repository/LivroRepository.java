package br.com.zupacademy.maxley.casadocodigo.repository;

import br.com.zupacademy.maxley.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
