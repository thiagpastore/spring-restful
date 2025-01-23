/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.restFul.driver.repository;

import com.example.restFul.driver.model.Driver;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Thiago
 */
public interface DriverRepository extends JpaRepository<Driver, Long> {
    
    @Query(value = 
           " SELECT * "
         + " FROM Driver "
         + " WHERE LOWER(name) = LOWER(?1) ", nativeQuery = true)
    Optional<Driver> findbyName(String name);
    
}
