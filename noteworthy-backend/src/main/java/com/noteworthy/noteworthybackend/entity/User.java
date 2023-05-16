package com.noteworthy.noteworthybackend.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @Id
    @Nonnull
    private String userEmailId;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notes> notes;
    @Column(name = "created_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDateTime;

    @Column(name = "modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedDateTime;

    @PrePersist
    public void prePersist() {
        createdDateTime = LocalDateTime.now();
        modifiedDateTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDateTime = LocalDateTime.now();
    }

    public User() {
    }

    public User(int userId, String userName, String userEmailId) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailId = userEmailId;
    }

    public User(int userId, String userName, @Nonnull String userEmailId, List<Notes> notes) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailId = userEmailId;
        this.notes = notes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
}
