package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
    
    @Column(name="id")
    private long id;
	@Column(name="username")
    private String username;

    public Employee() {
    	
    }
    
    public Employee(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Employee(String username) {
        this.username = username;
    }

    public Long getId() {

        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String username) {
        this.username = username;
    }
}
