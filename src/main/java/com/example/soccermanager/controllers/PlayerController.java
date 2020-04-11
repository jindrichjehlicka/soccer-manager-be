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
    public static final String origin = "*";

    @Autowired
    PlayerRepository PlayerRepository;

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/players")
    public List<Player> getAllPlayers() {

        return new ArrayList<>(PlayerRepository.findAll());
    }

    @CrossOrigin(origins = origin)
    @PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
    public Player addPlayer( @RequestBody Player player) {
        PlayerRepository.save(player);
        return player;
    }

    @CrossOrigin(origins = origin)
    @DeleteMapping(path = "/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        PlayerRepository.deleteById(id);
    }

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/players/{id}")
    public Optional<Player> getPlayer(@PathVariable int id) {
        return PlayerRepository.findById(id);
    }

    @CrossOrigin(origins = origin)
    @PutMapping(path = "/players")
    public Player editPlayer(@RequestBody Player player) {
        return PlayerRepository.save(player);
    }
}