package com.cars.repository.impl;

import com.cars.entity.Wheels;
import com.cars.mapper.WheelsMapper;
import com.cars.repository.WheelsDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WheelsDAOImpl implements WheelsDAO {
    private final JdbcTemplate jdbcTemplate;

    WheelsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String GET_ALL_WHEELS_Q = "SELECT * FROM car_wheels";
    private static final String GET_WHEELS_BY_ID_Q = "SELECT * FROM car_wheels WHERE car_wheels.id=?";
    private static final String CREATE_WHEELS_Q = "INSERT INTO car_wheels (size, wheel_type) VALUES (?, ?)";
    private static final String UPDATE_WHEELS_Q = "UPDATE car_wheels SET size = ?, wheel_type=? WHERE car_wheels.id = ?";

    private static final String DELETE_WHEELS_Q = "DELETE FROM car_wheels WHERE car_wheels.id = ?";
    private static final String DELETE_CAR_Q = "DELETE FROM cars WHERE wheels_id = ?";

    @Override
    public List<Wheels> getAllWheels() {
        return jdbcTemplate.query(GET_ALL_WHEELS_Q, new WheelsMapper());
    }

    @Override
    public Wheels getWheelsById(Integer id) {
        return jdbcTemplate.queryForObject(GET_WHEELS_BY_ID_Q, new WheelsMapper(), id);
    }

    @Override
    public Boolean createWheels(Wheels wheels) {
        var createWheels = jdbcTemplate.update(CREATE_WHEELS_Q, wheels.getSize(), wheels.getType());
        return createWheels != -1;
    }

    @Override
    public Boolean updateWheels(Integer id, Wheels wheels) {
        var updateWheels = jdbcTemplate.update(UPDATE_WHEELS_Q, wheels.getSize(), wheels.getType(), id);
        return updateWheels != -1;
    }

    @Override
    public Boolean deleteWheels(Integer id) {
        var deleteCar = jdbcTemplate.update(DELETE_CAR_Q, id);
        if (deleteCar != -1) {
            var deleteWheels = jdbcTemplate.update(DELETE_WHEELS_Q, id);
            return deleteWheels != -1;
        }
        return false;
    }
}
