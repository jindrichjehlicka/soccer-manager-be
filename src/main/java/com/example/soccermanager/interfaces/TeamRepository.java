package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Player;
import com.example.soccermanager.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
