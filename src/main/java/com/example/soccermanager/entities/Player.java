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
    //    todo add one to many relation
    private int team_id;
    private LocalDateTime deleted_at;


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

    public int getTeamId() {
        return team_id;
    }

    public void setTeamId(int team_id) {
        this.team_id = team_id;
    }

    public LocalDateTime getDeletedAt() {
        return deleted_at;
    }

    public void setDeletedAt(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

}
