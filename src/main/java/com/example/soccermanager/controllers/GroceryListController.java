package com.example.soccermanager.controllers;

import com.example.soccermanager.entities.Item;
import com.example.soccermanager.interfaces.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroceryListController {

  @Autowired
  GroceryListRepository groceryListRepository;

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(path = "/items")
  public List<Item> getAllItems(){
    List<Item> items = new ArrayList<>();
    groceryListRepository.findAll().forEach(items :: add);
    return items;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(path = "/items")
  public Item addItem(@RequestBody Item item){
    groceryListRepository.save(item);
    return item;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @DeleteMapping(path = "/items/{id}")
  public void deleteItem(@PathVariable int id){
    groceryListRepository.deleteById(id);
  }
}
