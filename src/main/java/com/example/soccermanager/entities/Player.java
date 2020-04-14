package com.example.soccermanager.entities;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String position;
    private boolean isSubstitute = false;
    //    todo add one to many relation
    private int teamId = 0;
    private LocalDateTime deletedAt;


    //    @Where(clause = "deleted_at=null")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean getIsSubstitute() {
        return isSubstitute;
    }

    public void setIsSubstitute(boolean isSubstitute) {
        this.isSubstitute = isSubstitute;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deleted_at) {
        this.deletedAt = deleted_at;
    }

}
