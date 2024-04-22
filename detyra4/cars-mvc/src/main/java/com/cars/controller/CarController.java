package com.cars.controller;

import com.cars.dto.Car;
import com.cars.dto.Engine;
import com.cars.dto.Wheels;
import com.cars.service.CarService;
import com.cars.service.EngineService;
import com.cars.service.WheelsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final EngineService engineService;
    private final WheelsService wheelsService;

    CarController(CarService carService, WheelsService wheelsService, EngineService engineService) {
        this.carService = carService;
        this.wheelsService = wheelsService;
        this.engineService = engineService;
    }

    private static String LOCATION = "plain-html";

    @GetMapping
    public String getCarsView(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return LOCATION + "/cars-view-plain";
    }

    @GetMapping("/form")
    public String getCarForm(Model model, @RequestParam(name = "car", required = false) Integer carId) {
        Car car;
        if (carId == null) {
            car = new Car();
        } else {
            car = carService.getCarById(carId);
        }
        model.addAttribute("car", car);

        List<Engine> enginesList = engineService.getAllEngines();
        model.addAttribute("enginesList", enginesList);

        List<Wheels> wheelsList = wheelsService.getAllWheels();
        model.addAttribute("wheelsList", wheelsList);

        return LOCATION + "/cars-view-form-plain";
    }

    @PostMapping
    public String addCar(@ModelAttribute("cars") Car car, BindingResult result) {
        if (result.hasErrors()) {
            return LOCATION + "/cars-view-form-plain";
        }
        if (car.getId() == null)
            carService.createCar(car);
        else
            carService.updateCar(car.getId(), car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/delete")
    public String deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
