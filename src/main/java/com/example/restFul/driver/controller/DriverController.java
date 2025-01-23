/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restFul.driver.controller;

import com.example.restFul.driver.model.Driver;
import com.example.restFul.driver.repository.DriverRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thiago
 */

@RestController
@RequestMapping("/driver")
public class DriverController {
    
    @Autowired
    private DriverRepository driverRepository;
    
    @GetMapping
    public ResponseEntity<List<Driver>> listAllDriver(){
        return ResponseEntity.ok(driverRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Driver> driverById(@PathVariable Long id){
        Optional<Driver> driver = driverRepository.findById(id);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Driver> insertDriver(@RequestBody Driver driver){
        if(driverRepository.findbyName(driver.getName().trim()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Driver driverNew = driverRepository.save(driver);
        return new ResponseEntity<> (driverNew, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver){
        if(!driverRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        driver.setId(id);
        Driver driver2 = driverRepository.save(driver);
        return ResponseEntity.ok(driver2);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id){
        if(!driverRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        driverRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
