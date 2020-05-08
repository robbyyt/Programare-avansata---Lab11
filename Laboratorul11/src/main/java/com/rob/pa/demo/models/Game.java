package com.rob.pa.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Games", schema = "ROBB")
public class Game {
    private long id;
    private String player1;
    private String player2;
    private String Board;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PLAYER1")
    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    @Basic
    @Column(name = "PLAYER1")
    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    @Basic
    @Column(name = "BOARD")
    public String getBoard() {
        return Board;
    }

    public void setBoard(String board) {
        Board = board;
    }
}
