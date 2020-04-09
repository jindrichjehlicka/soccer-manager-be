package com.example.soccermanager.controllers;


import com.example.soccermanager.entities.Game;
import com.example.soccermanager.interfaces.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    //  TODO: change
    public static final String DefaultUrl = "http://localhost:3000";

    @Autowired
    GameRepository GameRepository;

    @CrossOrigin(origins = DefaultUrl)
    @GetMapping(path = "/games")
    public List<Game> getAllGames() {

        return new ArrayList<>(GameRepository.findAll());
    }

    @CrossOrigin(origins = DefaultUrl)
    @PostMapping(path = "/games", consumes = "application/json", produces = "application/json")
    public Game addGame( @RequestBody Game game) {
        GameRepository.save(game);
        return game;
    }

    @CrossOrigin(origins = DefaultUrl)
    @DeleteMapping(path = "/game/{id}")
    public void deleteGame(@PathVariable int id) {
        GameRepository.deleteById(id);
    }

    @CrossOrigin(origins = DefaultUrl)
    @GetMapping(path = "/game/{id}")
    public Optional<Game> getOneMatch(@PathVariable int id) {

        return GameRepository.findById(id);
    }

    @CrossOrigin(origins = DefaultUrl)
    @PutMapping(path = "/game")
    public Game editPlayer(@RequestBody Game game) {
        return GameRepository.save(game);
    }
}