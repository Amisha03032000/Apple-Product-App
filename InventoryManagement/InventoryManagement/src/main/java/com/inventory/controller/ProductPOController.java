package com.inventory.controller;

import com.inventory.model.ProductPO;
import com.inventory.repository.ProductPORepository;
import com.inventory.designpattern.strategy.InventoryStrategy;
import com.inventory.designpattern.strategy.ProductPOStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productPO")
public class ProductPOController {

    @Autowired
    private ProductPORepository productPORepo;

    @GetMapping("/getAll")
    public List<ProductPO> getAll() {
        return productPORepo.getProductPOs();
    }

    @GetMapping("/getProductPO/{id}")
    public ProductPO getProductPO(@PathVariable int id) {
        return productPORepo.getProductPObyID(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProductPO productPO) {
        InventoryStrategy strategy = new InventoryStrategy(new ProductPOStrategy(productPORepo, productPO));
        strategy.executeUpdate();
    }

    @PostMapping("/save")
    public void save(@RequestBody ProductPO productPO) {
        InventoryStrategy strategy = new InventoryStrategy(new ProductPOStrategy(productPORepo, productPO));
        strategy.executeAdd();
    }

    @DeleteMapping("/delete/{id}")
    public void deletebyID(@PathVariable int id) {
        InventoryStrategy strategy = new InventoryStrategy(new ProductPOStrategy(productPORepo, id));
        strategy.executeDelete();
    }
}
