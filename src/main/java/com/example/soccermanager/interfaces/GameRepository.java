package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {


}
