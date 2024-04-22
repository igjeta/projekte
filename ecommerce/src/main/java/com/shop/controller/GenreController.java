package com.shop.controller;

import com.shop.domain.dto.genre.GenreDto;
import com.shop.domain.entity.GenreEntity;
import com.shop.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<GenreEntity> getAllGenres(){
        return genreService.allGenres();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createGenre(@Valid @RequestBody GenreDto genreDto){
        genreService.createGenre(genreDto);
        return ResponseEntity.ok("Genre was created successfully!");
    }

    @PostMapping("/update/{genreId}")
    public ResponseEntity<String> updateGenre(@Valid @RequestBody GenreDto genreDto,@PathVariable Integer genreId){
        genreService.updateGenre(genreDto,genreId);
        return ResponseEntity.ok("Genre with id "+genreId +" was updated");
    }

    @PutMapping("/action/{genreId}")
    public ResponseEntity<String> genreAction(@PathVariable Integer genreId,@RequestParam Boolean enabled){
        genreService.genreAction(genreId,enabled);
        String action = enabled ? "enabled" : "disabled";
        return ResponseEntity.ok("Genre with id " + genreId + " has been " + action + " successfully!");

    }
}
