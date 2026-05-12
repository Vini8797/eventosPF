package br.insper.eventosPF.repository;

import br.insper.eventosPF.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {}