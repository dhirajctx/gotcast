package com.gotcast.gotcast.controller;

;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gotcast.gotcast.entities.Actor;
import com.gotcast.gotcast.repositories.ActorRepo;
import com.gotcast.gotcast.services.ActorService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class ActorController {

    @Autowired
    ActorRepo repo;

    @Autowired
    ActorService actorService;


    @Autowired
    EntityManager entityManager;

    @GetMapping("/getActors")
    public List<Actor> getMsg() {
        List<Actor> list = repo.findAll();
        return list;
    }

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    // CREATE
    @PostMapping("/createActor")
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        return ResponseEntity.ok(actorService.createActor(actor));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    // READ BY ID
    @GetMapping("/getActor/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.getActorById(id));
    }

    // UPDATE
    @PutMapping("/updateActor/{id}")
    public ResponseEntity<Actor> updateActor(
            @PathVariable Long id,
            @RequestBody Actor actor) {

        return ResponseEntity.ok(actorService.updateActor(id, actor));
    }

    // DELETE
    @DeleteMapping("/deleteActor/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}