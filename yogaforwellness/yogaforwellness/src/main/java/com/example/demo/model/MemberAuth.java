package com.example.demo.model;

import java.util.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MemberAuth {

    public MemberAuth(String username, String password) {
        this.username = username;
        setPassword(password); // In practice, hash this password
    }
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    private String username;
    private String password; // In
    private byte[] encodedPassword;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Method to authenticate the user
    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Getters
    public String getUsername() {
        return username;
    }


    public byte[] getEncodedPassword(){
        return encodedPassword;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
        setEncodedPassword(password);
    }

    public void setEncodedPassword(String password) {
        byte[] encodedPassword = Base64.getEncoder().encode(password.getBytes());

        
        this.encodedPassword = encodedPassword;
    }




    
}
