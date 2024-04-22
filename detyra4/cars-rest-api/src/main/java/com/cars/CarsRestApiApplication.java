package com.cars;

import com.cars.service.CarService;
import com.cars.service.EngineService;
import com.cars.service.WheelsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarsRestApiApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(CarsRestApiApplication.class);

	@Autowired
	private CarService carService;
	@Autowired
	private WheelsService wheelsService;
	@Autowired
	private EngineService engineService;


	public static void main(String[] args) {
		SpringApplication.run(CarsRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("{}",carService.getAllCars());
		logger.info("{}",wheelsService.getAllWheels());
		logger.info("{}",engineService.getAllEngines());
	}
}
