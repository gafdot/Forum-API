package br.com.guigas.forum.config.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guigas.forum.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
}
