/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restFul.driver.controller;

import com.example.restFul.driver.model.Driver;
import com.example.restFul.service.DriverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DriverService driverService;
    
    @GetMapping
    public ResponseEntity<List<Driver>> listAllDriver(){
        return driverService.listAllDriver();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Driver> driverById(@PathVariable Long id){
        return driverService.driverById(id);
    }
    
    @PostMapping
    public ResponseEntity<Driver> insertDriver(@RequestBody Driver driver){
        return driverService.insertDriver(driver);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver){
        return driverService.updateDriver(id, driver);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id){
        return driverService.deleteDriver(id);
    }
    
}
