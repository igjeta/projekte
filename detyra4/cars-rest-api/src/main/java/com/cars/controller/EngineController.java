package com.cars.controller;

import com.cars.entity.Engine;
import com.cars.service.EngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine")
public class EngineController {
    private final EngineService engineService;

    EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @GetMapping
    public ResponseEntity<List<Engine>> getAllEngines() {
        return ResponseEntity.ok(engineService.getAllEngines());
    }

    @GetMapping("/{engineId}")
    public ResponseEntity<Engine> getEngineById(@PathVariable(name = "engineId") Integer id) {
        return ResponseEntity.ok(engineService.getEngineById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> addEngine(@RequestBody Engine engine) {
        return ResponseEntity.ok(engineService.createEngine(engine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEngine(@PathVariable Integer id, @RequestBody Engine engine) {
        return ResponseEntity.ok(engineService.updateEngine(id, engine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEngine(@PathVariable(name = "id") Integer engineId) {
        return ResponseEntity.ok(engineService.deleteEngine(engineId));
    }
}
