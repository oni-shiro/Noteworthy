package com.noteworthy.noteworthybackend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Notes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noteId;

    @OneToOne()
    @JoinColumn(name = "user_email_id")

    private User user;


    @Column(columnDefinition = "TEXT")
    private String note;

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

    public Notes() {
    }

    public Notes(int noteId, User user, String note) {
        this.noteId = noteId;
        this.user = user;
        this.note = note;
    }

    public Notes(int noteId, User user, String note, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.noteId = noteId;
        this.user = user;
        this.note = note;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
