package com.example.render_springboot_neon.repository;

import com.example.render_springboot_neon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
