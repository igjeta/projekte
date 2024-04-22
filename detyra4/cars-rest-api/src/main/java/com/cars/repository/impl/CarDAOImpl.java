package com.cars.repository.impl;

import com.cars.entity.Car;
import com.cars.mapper.CarMapper;
import com.cars.repository.CarDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {
    private final JdbcTemplate jdbcTemplate;

    public CarDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String GET_ALL_CARS_Q = "SELECT cars.id, cars.car_name, cars.from_year, cars.to_year, cars.type, car_engines.id AS engine_id, car_engines.engine_power, car_engines.engine_type, car_wheels.id AS wheels_id, car_wheels.size, car_wheels.wheel_type FROM cars JOIN car_engines ON cars.engine_id = car_engines.id JOIN car_wheels ON cars.wheels_id = car_wheels.id";
    private static final String GET_CAR_BY_ID_Q = "SELECT cars.id, cars.car_name, cars.from_year, cars.to_year, cars.type, car_engines.id AS engine_id, car_engines.engine_power, car_engines.engine_type, car_wheels.id AS wheels_id, car_wheels.size, car_wheels.wheel_type FROM cars JOIN car_engines ON cars.engine_id = car_engines.id JOIN car_wheels ON cars.wheels_id = car_wheels.id WHERE cars.id=?";
    private static final String CREATE_CAR_Q = "INSERT INTO cars (car_name, from_year, to_year, type, engine_id, wheels_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CAR_Q = "UPDATE cars SET car_name = ?, from_year = ?, to_year = ?, type = ?, engine_id = ?, wheels_id = ? WHERE cars.id = ?";

    private static final String DELETE_CAR_Q = "DELETE FROM cars WHERE id = ?";

    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(GET_ALL_CARS_Q,new CarMapper());
    }

    @Override
    public Car getCarById(Integer id) {
        return jdbcTemplate.queryForObject(GET_CAR_BY_ID_Q, new CarMapper(), id);
    }

    @Override
    public Boolean createCar(Car car) {
        var createCar = jdbcTemplate.update(CREATE_CAR_Q, car.getName(), car.getFromYear(), car.getToYear(), car.getType(), car.getEngine().getId(), car.getWheels().getId());
        return createCar != -1;
    }

    @Override
    public Boolean updateCar(Integer id, Car car) {
        var updateCar = jdbcTemplate.update(UPDATE_CAR_Q, car.getName(), car.getFromYear(), car.getToYear(), car.getType(), car.getEngine().getId(), car.getWheels().getId(), id);
        return updateCar != -1;
    }

    @Override
    public Boolean deleteCar(Integer id) {
        var deleteCar = jdbcTemplate.update(DELETE_CAR_Q, id);
        return deleteCar != -1;
    }
}
