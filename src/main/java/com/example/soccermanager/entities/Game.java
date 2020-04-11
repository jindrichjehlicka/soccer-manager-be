package com.example.soccermanager.entities;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
// Can't use "Match", because it's reserved keyword
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @ManyToMany
////            (cascade = CascadeType.MERGE)
//    @JoinTable(name = "team_game",
//            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "game_id",
//                    referencedColumnName = "id"))
//    private List<Team> teams;


    private String name;
    private String location;
    private LocalDateTime start_date;
    private LocalDateTime deleted_at;
    //TODO put into relation instead
    private int team_one_id;
    private int team_two_id;

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

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public LocalDateTime getStartDate() {

        return start_date;
    }

    public void setStartDate(LocalDateTime start_date) {

        this.start_date = start_date;
    }

    public LocalDateTime getDeletedAt() {

        return deleted_at;
    }

    public void setDeletedAt(LocalDateTime deleted_at) {

        this.deleted_at = deleted_at;
    }

    public int getTeamOneId() {

        return team_one_id;
    }

    public void setTeamOneId(int team_one_id) {
        this.team_one_id = team_one_id;
    }

    public int getTeamTwoId() {

        return team_two_id;
    }

    public void setTeamTwoId(int team_two_id) {

        this.team_two_id = team_two_id;
    }

}
