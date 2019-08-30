package com.store.app.repository;

import com.store.app.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {
        AppUser findByUserName(String userName);
}
