package com.store.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User_Role", uniqueConstraints = {
        @UniqueConstraint(name= "USER_ROLE_UK",
                columnNames = {"User_Id", "Role_Id"})})
@Data
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long Id;

    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @Column(name = "Role_Id", nullable = false)
    private Long userRole;
}
