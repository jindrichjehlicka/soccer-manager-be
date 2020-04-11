package com.example.soccermanager.entities;


import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @ManyToMany (mappedBy = "teams")
//    List<Game> games;

    private String name;
    //    TODO: Make country table and set foreign id
    private String country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDeletedAt() {
        return deleted_at;
    }

    public void setDeletedAt(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }


}