package com.store.app.repository;

import com.store.app.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findRoleNameByRoleId(Long roleId);
}
