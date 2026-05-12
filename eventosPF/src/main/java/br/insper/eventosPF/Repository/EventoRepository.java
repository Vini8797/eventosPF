package br.insper.eventosPF.Repository;

import br.insper.eventosPF.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {}