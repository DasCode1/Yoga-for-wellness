package com.example.demo.model;

import java.util.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MemberAuth {

    public MemberAuth(){
        
    }

    public MemberAuth(String username, String password) {
        this.username = setUserName(username);
                setPassword(password); // In practice, hash this password
            }

            private String generateUserName(String username) {
                   String[] components=username.split("_");
                   String element1 = components[0].substring(0,4);
                   String element2 = components[1].substring(0,4);
                   return element1.concat(element2);
            }
                @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    private String username;
    private String password; // In
    private byte[] encodedPassword;


    private Long memberId;
  
    public Long getMemberId(){
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    // Getters
    public String getUsername() {
        return username;
    }


    public byte[] getEncodedPassword(){
        return encodedPassword;
    }



    public void setPassword(String password) {
        setEncodedPassword(password);
    }

    public void setEncodedPassword(String password) {
        byte[] encodedPassword = Base64.getEncoder().encode(password.getBytes());

        
        this.encodedPassword = encodedPassword;
    }

    private String setUserName(String username) {
            return generateUserName(username);
    }





    
}
