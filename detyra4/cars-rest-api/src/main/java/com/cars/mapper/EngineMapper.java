package com.cars.mapper;

import com.cars.entity.Engine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EngineMapper implements RowMapper<Engine> {
    @Override
    public Engine mapRow(ResultSet rs, int rowNum) throws SQLException {
        Engine engine=new Engine();
        engine.setId(rs.getInt("id"));
        engine.setPower(rs.getInt("engine_power"));
        engine.setType(rs.getString("engine_type"));
        return engine;
    }
}
