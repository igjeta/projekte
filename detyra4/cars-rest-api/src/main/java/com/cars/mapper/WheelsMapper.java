package com.cars.mapper;

import com.cars.entity.Wheels;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WheelsMapper implements RowMapper<Wheels> {
    @Override
    public Wheels mapRow(ResultSet rs, int rowNum) throws SQLException {
        Wheels wheels = new Wheels();
        wheels.setId(rs.getInt("id"));
        wheels.setSize(rs.getString("size"));
        wheels.setType(rs.getString("wheel_type"));
        return wheels;
    }

}
