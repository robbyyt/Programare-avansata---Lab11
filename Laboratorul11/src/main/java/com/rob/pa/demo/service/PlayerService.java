package com.rob.pa.demo.service;

import com.rob.pa.demo.dao.PlayerDao;
import com.rob.pa.demo.entity.Player;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerService {
    @Autowired
    PlayerDao playerDao;

    public List<Player> getAllPlayers() {
        return this.playerDao.findAll();
    }

    public Player addPlayer(Player player) {
        return this.playerDao.save(player);
    }
}
