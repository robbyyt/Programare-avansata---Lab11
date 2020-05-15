package com.rob.pa.demo.controller;

import com.rob.pa.demo.dao.PlayerDao;
import com.rob.pa.demo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerDao.findAll();
    }

    @RequestMapping(value = "/addplayer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Player addPlayer(@RequestBody Player player) {
        return playerDao.save(player);
    }

    @RequestMapping(value = "/modifyplayer/{username}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Player modifyPlayer(@RequestBody Player player, @PathVariable("username") String username) {
        Player toModify = playerDao.findById(username).get();
        if (toModify == null) {
            return null;
        }
        playerDao.delete(toModify);
        return playerDao.save(player);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> deletePlayer(@PathVariable("username") String username) {
        Player player = playerDao.findById(username).get();
        System.out.println(player.getUsername());
        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.GONE);
        }
        playerDao.delete(player);
        return new ResponseEntity<>("Deleted...", HttpStatus.OK);
    }
}
