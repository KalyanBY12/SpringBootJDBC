package com.spring.boot.jdbc.SpringBootJDBC.Repository;

import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers()
    {
       String getPlayerQuery ="SELECT * FROM Player";

      // return jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
       return jdbcTemplate.query(getPlayerQuery, new PlayerMapper());
    }

    // READ(Get by ID)

    public Player getPlayerbyID(int id)
    {
        String getPlayerbyIDQuery = "SELECT * FROM Player WHERE ID =  ?";

        // using JDBCTemplate ==>

        return jdbcTemplate.queryForObject(getPlayerbyIDQuery, new BeanPropertyRowMapper<Player>(Player.class) , new Object[]{id});

    }

    // inserting new row
    public int insertPlayer(Player player)
    {
        String insertPlayerQuery = "INSERT INTO Player VALUES(?,?,?,?,?,?)";

        return jdbcTemplate.update(insertPlayerQuery,new Object[]{player.getId(), player.getName(), player.getAge(), player.getNationality(), new Timestamp(player.getDob().getTime()), player.getDesignation()});


    }

    // UPDATE a row
    public int updatePlayerInfo(Player player){
        String updateQuery= "UPDATE Player "+" set Name =? , Age =?, Nationality =? , DOB =? , Designation =? " +
                " where ID=?" ;
        return jdbcTemplate.update(updateQuery,new Object[]{player.getName(),player.getAge(),
                player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation(),player.getId()});
    }

    // DELETE Any Row
    public int deletePlayer(int id)
    {
        String deleteQuery = "DELETE FROM Player "+" WHERE ID = ?";

        return jdbcTemplate.update(deleteQuery, new Object[]{id});
    }

    //////********** using row mapping instead BEANPROPERTYROWMAPPER *********
    private static final class PlayerMapper implements RowMapper
    {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Player player = new Player();

            player.setId(rs.getInt("ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setNationality(rs.getString("Nationality"));
            player.setDob(rs.getDate("DOB"));
            player.setDesignation(rs.getInt("Designation"));

            return player;
        }
    }
}
