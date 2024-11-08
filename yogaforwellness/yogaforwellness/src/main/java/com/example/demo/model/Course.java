/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.model;

/**
 *
 * @author vdasarathy
 */
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    private CourseType courseType; // Enum as primary key

    private String courseDescription; // String for course description

    // Constructor
    public Course(CourseType courseType, String courseDescription) {
        this.courseType = courseType;
        this.courseDescription = courseDescription;
    }

    // Default constructor
    public Course() {
    }

    // Getters and Setters
    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseType=" + courseType +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
