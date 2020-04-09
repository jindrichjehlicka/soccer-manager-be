package com.example.soccermanager.controllers;


import com.example.soccermanager.entities.Player;
import com.example.soccermanager.interfaces.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    //  TODO: change
    public static final String DefaultUrl = "http://localhost:3000";

    @Autowired
    PlayerRepository PlayerRepository;

    @CrossOrigin(origins = DefaultUrl)
    @GetMapping(path = "/players")
    public List<Player> getAllPlayers() {
        return new ArrayList<>(PlayerRepository.findAll());
    }

    @CrossOrigin(origins = DefaultUrl)
    @PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
    public Player addPlayer( @RequestBody Player player) {
        PlayerRepository.save(player);
        return player;
    }

    @CrossOrigin(origins = DefaultUrl)
    @DeleteMapping(path = "/player/{id}")
    public void deletePlayer(@PathVariable int id) {
        PlayerRepository.deleteById(id);
    }

    @CrossOrigin(origins = DefaultUrl)
    @GetMapping(path = "/player/{id}")
    public Optional<Player> getPlayer(@PathVariable int id) {
        return PlayerRepository.findById(id);
    }

    @CrossOrigin(origins = DefaultUrl)
    @PutMapping(path = "/player")
    public Player editPlayer(@RequestBody Player player) {
        return PlayerRepository.save(player);
    }
}