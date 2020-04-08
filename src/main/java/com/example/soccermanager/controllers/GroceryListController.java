package com.example.soccermanager.controllers;

import com.example.soccermanager.entities.Item;
import com.example.soccermanager.interfaces.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GroceryListController {
  //  TODO: change
  public static final String DefaultUrl = "http://localhost:3000";

  @Autowired
  GroceryListRepository groceryListRepository;

  @CrossOrigin(origins = DefaultUrl)
  @GetMapping(path = "/items")
  public List<Item> getAllItems() {
    return new ArrayList<>(groceryListRepository.findAll());
  }

  @CrossOrigin(origins = DefaultUrl)
  @PostMapping(path = "/items")
  public Item addItem(@RequestBody Item item) {
    groceryListRepository.save(item);
    return item;
  }

  @CrossOrigin(origins = DefaultUrl)
  @DeleteMapping(path = "/items/{id}")
  public void deleteItem(@PathVariable int id) {
    groceryListRepository.deleteById(id);
  }

  @CrossOrigin(origins = DefaultUrl)
  @GetMapping(path = "/items/{id}")
  public Optional<Item> getOneItem(@PathVariable int id) {
    return groceryListRepository.findById(id);
  }
}
