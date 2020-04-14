package com.example.soccermanager.controllers;


import com.example.soccermanager.entities.Game;
import com.example.soccermanager.entities.Team;
import com.example.soccermanager.interfaces.GameRepository;
import com.example.soccermanager.interfaces.PlayerRepository;
import com.example.soccermanager.interfaces.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
  @Autowired
  PlayerRepository PlayerRepository;
  @Autowired
  GameRepository GameRepository;

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
  @Transactional
  public long deleteTeam(@PathVariable int id) {
//TODO remake with relations
    TeamRepository.deleteById(id);
    List<Game> matchesToUpdateByIdOne = GameRepository.findAllByTeamOneId(id);
    List<Game> matchesToUpdateByIdTwo = GameRepository.findAllByTeamTwoId(id);

    for (Game game : matchesToUpdateByIdOne) {
      game.setTeamOneId(0);
      GameRepository.save(game);
    }

    for (Game game : matchesToUpdateByIdTwo) {
      game.setTeamTwoId(0);
      GameRepository.save(game);
    }
    return PlayerRepository.deleteByTeamId(id);

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