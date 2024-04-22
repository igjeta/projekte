package com.cars.controller;

import com.cars.dto.Wheels;
import com.cars.service.WheelsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wheels")
public class WheelsController {
    private final WheelsService wheelsService;

    WheelsController(WheelsService wheelsService){
        this.wheelsService=wheelsService;
    }
    private static String LOCATION = "plain-html";

    @GetMapping
    public String getWheelsView(Model model) {
        model.addAttribute("wheels", wheelsService.getAllWheels());
        return LOCATION + "/wheels-view-plain";
    }

    @GetMapping("/form")
    public String getWheelsForm(Model model, @RequestParam(name = "wheels", required = false) Integer wheelsId) {
        if (wheelsId == null) {
            model.addAttribute("wheels", new Wheels());

        } else {
            var wheels = wheelsService.getWheelsById(wheelsId);
            model.addAttribute("wheels", wheels);
        }

        return LOCATION + "/wheels-view-form-plain";
    }

    @PostMapping
    public String addWheels(@ModelAttribute("wheels") Wheels wheels, BindingResult result) {
        if (result.hasErrors()) {
            return LOCATION + "/wheels-view-form-plain";
        }
        if (wheels.getId() == null)
            wheelsService.createWheels(wheels);
        else
            wheelsService.updateWheels(wheels.getId(), wheels);
        return "redirect:/wheels";
    }

    @GetMapping("/{id}/delete")
    public String deleteWheels(@PathVariable Integer id) {
        wheelsService.deleteWheels(id);
        return "redirect:/wheels";
    }
}
