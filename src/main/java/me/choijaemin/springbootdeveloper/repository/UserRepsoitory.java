package me.choijaemin.springbootdeveloper.repository;

import me.choijaemin.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepsoitory extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
