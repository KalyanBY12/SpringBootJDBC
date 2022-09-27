package com.spring.boot.jdbc.SpringBootJDBC.Controller;
import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class PlayerController {
    @Autowired
    PlayerDAO dao;
    public List<Player> getALlPlayerdb()
    {
        return dao.getAllPlayers();
    }

    @GetMapping("/players-json")
    public List<Player> getAllPlayerFromDBJson()
    {
        return getALlPlayerdb();
    }

   //@GetMapping("/playerById")
   // public Player getPlayer

}