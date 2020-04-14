package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
  List<Player> findByTeamId(int id);

  long deleteByTeamId(int id);
}
