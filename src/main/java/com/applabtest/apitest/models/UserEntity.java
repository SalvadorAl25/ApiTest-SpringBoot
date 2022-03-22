package com.applabtest.apitest.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author Salvador Alcala
 * UserEntity es la clase donde se modela la tabla 'users'
 */

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long userId;

    private String userName;

    private String userLastName;

    private String userEmail;

    private Boolean status;

    private String imgProfile;

    @ManyToMany
    @JoinTable(
            name = "userRoles"
            ,joinColumns = @JoinColumn(name = "userId")
            ,inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<RolesEntity> role;

    public UserEntity() {
    }

    public UserEntity(Long userId, String userName, String userLastName, String userEmail, Boolean status, String imgProfile, List<RolesEntity> role) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.status = status;
        this.imgProfile = imgProfile;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<RolesEntity> getRole() {
        return role;
    }

    public void setRole(List<RolesEntity> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", status=" + status +
                ", imgProfile='" + imgProfile + '\'' +
                ", role=" + role +
                '}';
    }

}
