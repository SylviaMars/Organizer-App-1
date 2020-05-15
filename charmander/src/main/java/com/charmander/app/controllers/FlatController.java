package com.charmander.app.controllers;

import com.charmander.app.model.CreateFlatDto;
import com.charmander.app.model.EventDto;
import com.charmander.app.service.flat.IFlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flat")
public class FlatController {

    @Autowired private IFlatService iFlatService;

    @CrossOrigin(maxAge = 3600)
    @PostMapping("/create")
    public ResponseEntity<Boolean> createFlat(@RequestBody CreateFlatDto flat) {
        return iFlatService.createFlat(flat);
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping("/find/events")
    public ResponseEntity<List<EventDto>> findEventsByFlat(@PathVariable Long flatId) {
        return iFlatService.findEventsByFlat(flatId);
    }
}