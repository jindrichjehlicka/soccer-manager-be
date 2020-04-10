package com.example.soccermanager.controllers;


import com.example.soccermanager.entities.Game;
import com.example.soccermanager.entities.Player;
import com.example.soccermanager.entities.Team;
import com.example.soccermanager.interfaces.GameRepository;
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
    public List<Team> getAllGames() {
        return new ArrayList<>(TeamRepository.findAll());
    }

    @CrossOrigin(origins = origin)
    @PostMapping(path = "/teams")
    public Team addGame(@RequestBody Team team) {

        TeamRepository.save(team);
        return team;
    }

    @CrossOrigin(origins = origin)
    @DeleteMapping(path = "/team/{id}")
    public void deleteMach(@PathVariable int id) {
        TeamRepository.deleteById(id);
    }

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/team/{id}")
    public Optional<Team> getOneItem(@PathVariable int id) {
        return TeamRepository.findById(id);
    }

    @CrossOrigin(origins = origin)
    @PutMapping(path = "/team")
    public Team editPlayer(@RequestBody Team team) {
        return TeamRepository.save(team);
    }
}