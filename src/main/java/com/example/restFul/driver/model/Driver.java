/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restFul.driver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Thiago
 */

@Entity
public class Driver {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    public int getAge(){
        if(birth != null){
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(System.currentTimeMillis());
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(birth);
            return cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        }
        return -1;
    }
}