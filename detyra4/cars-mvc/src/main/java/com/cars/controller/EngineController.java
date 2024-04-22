package com.cars.controller;

import com.cars.dto.Engine;
import com.cars.service.EngineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/engine")
public class EngineController {
    private final EngineService engineService;

    EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    private static String LOCATION = "plain-html";

    @GetMapping
    public String getEngineView(Model model) {
        model.addAttribute("engine", engineService.getAllEngines());
        return LOCATION + "/engine-view-plain";
    }

    @GetMapping("/form")
    public String getEngineForm(Model model, @RequestParam(name = "engine", required = false) Integer engineId) {
        if (engineId == null) {
            model.addAttribute("engine", new Engine());

        } else {
            var engine = engineService.getEngineById(engineId);
            model.addAttribute("engine", engine);
        }

        return LOCATION + "/engine-view-form-plain";
    }

    @PostMapping
    public String addEngine(@ModelAttribute("engine") Engine engine, BindingResult result) {
        if (result.hasErrors()) {
            return LOCATION + "/engine-view-form-plain";
        }
        if (engine.getId() == null)
            engineService.createEngine(engine);
        else
            engineService.updateEngine(engine.getId(), engine);
        return "redirect:/engine";
    }

    @GetMapping("/{id}/delete")
    public String deleteEngine(@PathVariable Integer id) {
        engineService.deleteEngine(id);
        return "redirect:/engine";
    }
}
