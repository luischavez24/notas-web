package org.guis.notas.web.repositories;

import org.guis.notas.web.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserCredentials, String> {

    Optional<UserCredentials> findByUsername(String username);

}
