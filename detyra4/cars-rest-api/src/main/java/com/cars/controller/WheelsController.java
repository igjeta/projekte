package com.cars.controller;

import com.cars.entity.Wheels;
import com.cars.service.WheelsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wheels")
public class WheelsController {

    private final WheelsService wheelsService;

    WheelsController(WheelsService wheelsService) {
        this.wheelsService = wheelsService;
    }

    @GetMapping
    public ResponseEntity<List<Wheels>> getAllWheels() {
        return ResponseEntity.ok(wheelsService.getAllWheels());
    }

    @GetMapping("/{wheelsId}")
    public ResponseEntity<Wheels> getWheelsById(@PathVariable(name = "wheelsId") Integer id) {
        return ResponseEntity.ok(wheelsService.getWheelsById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> addWheels(@RequestBody Wheels wheels) {
        return ResponseEntity.ok(wheelsService.createWheels(wheels));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateWheels(@PathVariable Integer id, @RequestBody Wheels wheels) {
        return ResponseEntity.ok(wheelsService.updateWheels(id, wheels));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteWheels(@PathVariable(name = "id") Integer wheelsId) {
        return ResponseEntity.ok(wheelsService.deleteWheels(wheelsId));
    }
}
