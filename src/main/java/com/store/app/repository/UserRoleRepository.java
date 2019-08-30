package com.store.app.repository;

import com.store.app.entity.AppRole;
import com.store.app.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository <UserRole, Long> {
    List<UserRole> findRoleIdByUserId(Long User_Id);
}
