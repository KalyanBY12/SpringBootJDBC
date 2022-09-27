package com.spring.boot.jdbc.SpringBootJDBC;

import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;


@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner
{
	@Autowired
	// PlayerDAO dao;
	PlayerRepository repo;

	@Override
	public void run(String... args) throws Exception 
	{
		/*
		System.out.println("----------Get EACH PLAYER INFO--------------\n");
		System.out.println(dao.getAllPlayers());

		System.out.println("----------GET PLAYER BY ID----------\n");
		System.out.println(dao.getPlayerbyID(2));

		System.out.println("----------INSERT PLAYER----------\n");
		System.out.println(dao.insertPlayer(new Player(4, "Sushant",29,"Canada",new Date(System.currentTimeMillis()),10)));
		System.out.println("----------Updating a player info PLAYER----------\n");
		System.out.println(new Player(4,"Maya",30,"Canada",new Date(System.currentTimeMillis()),4));

		System.out.println("----------Delete a player info PLAYER----------\n");
		System.out.println(dao.deletePlayer(2));

		*/

		// *********** CRUD without DATABASE QUERIES *************
		// INSERT
		repo.insertPlayer(new Player("Chaya",22,"INDIAN",Date.valueOf("2000-01-01"),1));
		repo.insertPlayer(new Player("Ross",23,"UK",Date.valueOf("2005-06-01"),1));

		System.out.println(repo.getPlayerById(1));

		// UPDATE
		//repo.updatePlayer(new Player("Chaya",22,"USA",Date.valueOf("2000-01-01"),1));

		// DELETE
		repo.deleteById(2);


	}

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
}
