package com.example.soccermanager.interfaces;

import com.example.soccermanager.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepository extends JpaRepository<Item, Integer> {


}