package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
  // TODO change to relation
  List<Game> findAllByTeamOneId(int id);

  List<Game> findAllByTeamTwoId(int id);


}
