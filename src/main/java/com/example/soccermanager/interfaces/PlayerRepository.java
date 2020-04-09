package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {


}
