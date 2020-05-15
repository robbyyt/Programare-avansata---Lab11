package com.rob.pa.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Players")
public class Player {
    @Column(name = "USERNAME")
    @Id
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Player(String username) {
        this.username = username;
    }

    public Player() {}

    @Override
    public String toString() {
        return "Player{" + "username='" + username + "'}";
    }
}
