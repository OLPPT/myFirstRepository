package com.example.demo.dao;

import com.example.demo.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by OL-PC on 2018/04/11.
 */
@Repository
public class SpitterDaoImpl implements SpitterDao {

    private JdbcOperations jdbcTemplate;

    @Autowired
    public SpitterDaoImpl(@Qualifier("jdbcTemplate") JdbcOperations jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Spitter save(Spitter spitter) {
        String sql = "insert into Spitter(id,username, password, first_name, last_name, email) values(?,?,?,?,?,?)";
        Object[] params = new Object[]{
                spitter.getId(),
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getPassword(),
                spitter.getEmail()
        };
        jdbcTemplate.update(sql,params);
        return spitter;
    }

    @Override
    public Spitter findById(Integer id) {
        String sql = "select id,username,password,first_name,last_name,email from Spitter where id = ?";
        return jdbcTemplate.queryForObject(sql,this::mapSpitter,id);
//        return jdbcTemplate.queryForObject(sql,
//                (rs,i)->{
//                    Spitter spitter = new Spitter();
//                    spitter.setId(rs.getInt("id"));
//                    spitter.setUsername(rs.getString("username"));
//                    spitter.setPassword(rs.getString("password"));
//                    spitter.setFirstName(rs.getString("first_name"));
//                    spitter.setLastName(rs.getString("last_name"));
//                    spitter.setEmail(rs.getString("email"));
//                    return spitter;
//                },id);
//        return jdbcTemplate.queryForObject(sql, new RowMapper<Spitter>() {
//                @Nullable
//                @Override
//                public Spitter mapRow(ResultSet rs, int i) throws SQLException {
//                    Spitter spitter = null;
//                    if (rs != null){
//                        spitter = new Spitter();
//                        spitter.setId(rs.getInt("id"));
//                        spitter.setUsername(rs.getString("username"));
//                        spitter.setPassword(rs.getString("password"));
//                        spitter.setFirstName(rs.getString("first_name"));
//                        spitter.setLastName(rs.getString("last_name"));
//                        spitter.setEmail(rs.getString("email"));
//                    }
//                    return spitter;
//                }
//            },id);
    }
    public Spitter mapSpitter(ResultSet rs,int row) throws SQLException{
        Spitter spitter = new Spitter();
        spitter.setId(rs.getInt("id"));
        spitter.setUsername(rs.getString("username"));
        spitter.setPassword(rs.getString("password"));
        spitter.setFirstName(rs.getString("first_name"));
        spitter.setLastName(rs.getString("last_name"));
        spitter.setEmail(rs.getString("email"));
        return spitter;
    }
}
