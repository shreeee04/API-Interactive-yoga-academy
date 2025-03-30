package com.example.artf.Model;

import jakarta.persistence.*;

@Entity
public class YogaClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // Many to One relationship with User (User can create many YogaClasses)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // Foreign key column in database
    private User user;

    // Many to One relationship with Instructor (Instructor teaches many YogaClasses)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id") // Foreign key column in database
    private Instructor instructor;

    // Constructors
    public YogaClass() {}

    public YogaClass(String name, String description, User user, Instructor instructor) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.instructor = instructor;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
}
