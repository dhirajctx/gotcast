package com.gotcast.gotcast.services;

import com.gotcast.gotcast.entities.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {

    Actor createActor(Actor actor);

    List<Actor> getAllActors();

    Actor getActorById(Long id);

    Actor updateActor(Long id, Actor actor);

    void deleteActor(Long id);
}
