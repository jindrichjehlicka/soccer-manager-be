package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {


}
