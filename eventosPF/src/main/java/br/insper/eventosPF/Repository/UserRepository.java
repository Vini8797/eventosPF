package br.insper.eventosPF.Repository;

import br.insper.eventosPF.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}