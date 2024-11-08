// src/main/java/com/example/demo/model/Member.java

package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private List<CourseType> course;

    private Gender gender;

    private  String occupation;

    private Timing timing;

    private String othertiming;


    private int age;
    private ScheduleDetails scheduleDetails;


    @OneToMany(cascade=CascadeType.ALL)
    private List<HealthIssue> healthIssue;
    



    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
     public List<CourseType> getCourseType() {
        return course;
    }

    public void setCourseType(List<CourseType> course) {
        this.course = course;
    }
      public Gender getGender() {
        return gender;
    }

    // Setter for gender
    public void setGender(Gender gender) {
        this.gender = gender;
    }
     public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
      public String getOccupation() {
        return occupation;
    }

    // Setter for address
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
      public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }

    public String getOtherTiming(){
        return othertiming;
    }
    public void setOtherTiming(String othertiming){
        if(this.timing ==Timing.OTHER){
        this.othertiming=othertiming;
        }else{
            this.othertiming=null;
        }
    }
     // Getter for scheduleDetails
    public ScheduleDetails getScheduleDetails() {
        return scheduleDetails;
    }

    // Setter for scheduleDetails
    public void setScheduleDetails(ScheduleDetails scheduleDetails) {
        this.scheduleDetails = scheduleDetails;
    }

    public List<HealthIssue> getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(List<HealthIssue> healthIssue) {
        this.healthIssue = healthIssue;
    }
}