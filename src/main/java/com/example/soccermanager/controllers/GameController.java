package com.example.soccermanager.controllers;


import com.example.soccermanager.entities.Game;
import com.example.soccermanager.interfaces.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    //  TODO: change
    public static final String origin = "*";

    @Autowired
    GameRepository GameRepository;

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/games")
    public List<Game> getAllGames() {

        return new ArrayList<>(GameRepository.findAll());
    }

    @CrossOrigin(origins = origin)
    @PostMapping(path = "/games")
    public Game addGame(@RequestBody Game game) {

        GameRepository.save(game);
        return game;
    }

    @CrossOrigin(origins = origin)
    @DeleteMapping(path = "/games/{id}")
    public HashMap<String, String> deleteGame(@PathVariable int id) {

        GameRepository.deleteById(id);

        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Game has been deleted");
        return response;
    }

    @CrossOrigin(origins = origin)
    @GetMapping(path = "/games/{id}")
    public Optional<Game> getOneMatch(@PathVariable int id) {

        return GameRepository.findById(id);
    }

    @CrossOrigin(origins = origin)
    @PutMapping(path = "/games")
    public Game editPlayer(@RequestBody Game game) {

        return GameRepository.save(game);
    }
}