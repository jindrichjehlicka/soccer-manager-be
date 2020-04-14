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
    private LocalDateTime startDate;
    private LocalDateTime deletedAt;
    //TODO put into relation instead
    private int teamOneId;
    private int teamTwoId;

    //    @Where(clause = "deletedAt=null")
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

        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {

        this.startDate = startDate;
    }

    public LocalDateTime getDeletedAt() {

        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {

        this.deletedAt = deletedAt;
    }

    public int getTeamOneId() {

        return teamOneId;
    }

    public void setTeamOneId(int teamOneId) {
        this.teamOneId = teamOneId;
    }

    public int getTeamTwoId() {

        return teamTwoId;
    }

    public void setTeamTwoId(int teamTwoId) {

        this.teamTwoId = teamTwoId;
    }

}
