package com.cars.client;

import com.cars.dto.Engine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface EngineClient {
    @GetExchange
    ResponseEntity<List<Engine>> getAllEngines();

    @GetExchange("/{engineId}")
    ResponseEntity<Engine> getEngineById(@PathVariable(name = "engineId") Integer id);

    @PostExchange
    ResponseEntity<Boolean> addEngine(@RequestBody Engine engine);

    @PutExchange("/{id}")
    ResponseEntity<Boolean> updateEngine(@PathVariable Integer id, @RequestBody Engine engine);

    @DeleteExchange("/{id}")
    ResponseEntity<Boolean> deleteEngine(@PathVariable(name = "id") Integer engineId);
}
