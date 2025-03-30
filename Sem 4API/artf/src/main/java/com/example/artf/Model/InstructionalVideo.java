package com.example.artf.Model;

import jakarta.persistence.*;

@Entity
public class InstructionalVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yoga_class_id")
    private YogaClass yogaClass;

    // Default constructor
    public InstructionalVideo() {}

    // // Parameterized constructor
    // public InstructionalVideo(String title, String url, User user, YogaClass yogaClass) {
    //     this.title = title;
    //     this.url = url;
    //     this.user = user;
    //     this.yogaClass = yogaClass;
    // }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public YogaClass getYogaClass() {
        return yogaClass;
    }

    public void setYogaClass(YogaClass yogaClass) {
        this.yogaClass = yogaClass;
    }
}
