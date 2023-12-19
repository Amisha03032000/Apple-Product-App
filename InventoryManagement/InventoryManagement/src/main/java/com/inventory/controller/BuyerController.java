package com.inventory.controller;

import com.inventory.model.Buyer;
import com.inventory.repository.BuyerRepository;
import com.inventory.designpattern.strategy.BuyerStrategy;
import com.inventory.designpattern.strategy.InventoryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @apiNote - Controller for Buyers
 */
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    // Dependency Injection by Autowiring for Buyer Repo
    @Autowired
    private BuyerRepository buyerRepo;

    // Getting All the buyers
    @GetMapping("/getAll")
    public List<Buyer> getAll() {
        return buyerRepo.getBuyers();
    }

    // Saving the buyer data in DB
    @PostMapping("/save")
    public void save(@RequestBody Buyer buyer) {
        InventoryStrategy strategy = new InventoryStrategy(new BuyerStrategy(buyerRepo, buyer));
        strategy.executeAdd();
    }

    // Get specific Buyer
    @GetMapping("/getBuyer/{id}")
    public Buyer getBuyer(@PathVariable int id) {
        return buyerRepo.getBuyerbyID(id);
    }

    // Delete Specific Buyer
    @DeleteMapping("/delete/{id}")
    public void deletebyID(@PathVariable int id) {
        InventoryStrategy strategy = new InventoryStrategy(new BuyerStrategy(buyerRepo, id));
        strategy.executeDelete();
    }

    // Update Buyer Info
    @PutMapping("/update")
    public void update(@RequestBody Buyer buyer) {
        InventoryStrategy strategy = new InventoryStrategy(new BuyerStrategy(buyerRepo, buyer));
        strategy.executeUpdate();
    }

}