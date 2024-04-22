package com.igjeta.detyra.detyra1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeDemo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(ShapeDemo.class);


    @Autowired
    private ShapeService shapeService;

    @Override
    public void run(String... args) throws Exception {
        Double test = shapeService.calculateArea3D("cylinder",5.0,4.0);
        logger.info("Siperfaqja eshte {}",test);

    }

}
