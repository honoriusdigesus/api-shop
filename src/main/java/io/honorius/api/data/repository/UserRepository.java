package io.honorius.api.data.repository;

import io.honorius.api.data.enttity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
