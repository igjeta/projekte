package com.cars.mapper;

import com.cars.entity.Car;
import com.cars.entity.Engine;
import com.cars.entity.Wheels;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException { Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("car_name"));
        car.setFromYear(rs.getString("from_year"));
        car.setToYear(rs.getString("to_year"));

        Engine engine = new Engine();
        engine.setId(rs.getInt("engine_id"));
        engine.setPower(rs.getInt("engine_power"));
        engine.setType(rs.getString("engine_type"));

        Wheels wheels = new Wheels();
        wheels.setId(rs.getInt("wheels_id"));
        wheels.setSize(rs.getString("size"));
        wheels.setType(rs.getString("wheel_type"));

        car.setEngine(engine);
        car.setWheels(wheels);

        return car;

    }
}
