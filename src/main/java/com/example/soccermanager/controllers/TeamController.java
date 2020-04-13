package com.example.soccermanager.controllers;


import com.example.soccermanager.entities.Player;
import com.example.soccermanager.entities.Team;
import com.example.soccermanager.interfaces.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {
    //  TODO: change
    public static final String origin = "*";

    @Autowired
    TeamRepository TeamRepository;

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/teams")
    public List<Team> getAllTeams() {

        return new ArrayList<>(TeamRepository.findAll());
    }

    @CrossOrigin(origins = origin)
    @PostMapping(path = "/teams")
    public Team addTeam(@RequestBody Team team) {

        TeamRepository.save(team);
        return team;
    }

    @CrossOrigin(origins = origin)
    @DeleteMapping(path = "/teams/{id}")
    public void deleteTeam(@PathVariable int id) {

        TeamRepository.deleteById(id);
    }

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/teams/{id}")
    public Optional<Team> getOneItem(@PathVariable int id) {

        return TeamRepository.findById(id);
    }

    @CrossOrigin(origins = origin)
    @PutMapping(path = "/teams")
    public Team editTeam(@RequestBody Team team) {

        return TeamRepository.save(team);
    }


}