/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restFul.service;

import com.example.restFul.driver.model.Driver;
import com.example.restFul.driver.repository.DriverRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Thiago
 */
@Component
public class DriverService {
    
    @Autowired
    private DriverRepository driverRepository;
    
    public ResponseEntity<List<Driver>> listAllDriver(){
        return ResponseEntity.ok(driverRepository.findAll());
    }
    
    public ResponseEntity<Driver> driverById(Long id){
        Optional<Driver> driver = driverRepository.findById(id);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<Driver> insertDriver(Driver driver){
        if(driverRepository.findbyName(driver.getName().trim()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Driver driverNew = driverRepository.save(driver);
        return new ResponseEntity<> (driverNew, HttpStatus.CREATED);
    }
    
    public ResponseEntity<Driver> updateDriver(Long id, Driver driver){
        if(!driverRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        driver.setId(id);
        Driver driver2 = driverRepository.save(driver);
        return ResponseEntity.ok(driver2);
    }
    
    public ResponseEntity<Void> deleteDriver(Long id){
        if(!driverRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        driverRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
