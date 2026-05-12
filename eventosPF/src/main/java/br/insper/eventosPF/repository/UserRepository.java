package br.insper.eventosPF.repository;

import br.insper.eventosPF.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}