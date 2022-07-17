package com.electrosignal.PhoneBook.repository;

import com.electrosignal.PhoneBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
