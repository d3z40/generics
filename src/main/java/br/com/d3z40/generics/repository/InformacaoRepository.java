package br.com.d3z40.generics.repository;

import br.com.d3z40.generics.model.Informacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacaoRepository extends JpaRepository<Informacao, Long> {
}
