package com.cars.client;

import com.cars.dto.Wheels;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface WheelsClient {
    @GetExchange
    ResponseEntity<List<Wheels>> getAllWheels();

    @GetExchange("/{wheelsId}")
    ResponseEntity<Wheels> getWheelsById(@PathVariable(name = "wheelsId") Integer id);

    @PostExchange
    ResponseEntity<Boolean> addWheels(@RequestBody Wheels wheels);

    @PutExchange("/{id}")
    ResponseEntity<Boolean> updateWheels(@PathVariable Integer id, @RequestBody Wheels wheels);

    @DeleteExchange("/{id}")
    ResponseEntity<Boolean> deleteWheels(@PathVariable(name = "id") Integer wheelsId);
}
