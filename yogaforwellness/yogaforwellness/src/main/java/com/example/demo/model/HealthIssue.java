package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class 


HealthIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private HealthIssueEnum healthIssue;

    private String other;

    // Getter and Setter for healthIssue
    public HealthIssueEnum getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(HealthIssueEnum healthIssue) {
        this.healthIssue = healthIssue;
    }

    // Getter for other
    public String getOther() {
        return other;
    }

    // Setter for other with conditional logic
    public void setOther(String other) {
        if (this.healthIssue == HealthIssueEnum.OTHER) {
            this.other = other; // Set 'other' only if healthIssue is OTHER
        } else {
            this.other = null; // Optionally clear 'other' if healthIssue is not OTHER
        }
    }
}