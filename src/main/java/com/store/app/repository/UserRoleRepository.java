package com.store.app.repository;

import com.store.app.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository <UserRole, Long> {
    List<UserRole> findRoleIdByUserId(Long User_Id);
}
