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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID", nullable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Role_Id", nullable = false)
    private AppRole appRole;
}
