package com.gotcast.gotcast.services;

import com.gotcast.gotcast.entities.Actor;
import com.gotcast.gotcast.repositories.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepo actorRepository;

    public ActorServiceImpl(ActorRepo actorRepository) {
        this.actorRepository = actorRepository;
        }

        @Override
        public Actor createActor (Actor actor){
            return actorRepository.save(actor);
        }


    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found with id: " + id));
    }

    @Override
    public Actor updateActor(Long id, Actor actor) {
        Actor existingActor = getActorById(id);
        existingActor.setName(actor.getName());
        existingActor.setAge(actor.getAge());
        return actorRepository.save(existingActor);
    }

    @Override
    public void deleteActor(Long id) {
        if (!actorRepository.existsById(id)) {
            throw new RuntimeException("Actor not found with id: " + id);
        }
        actorRepository.deleteById(id);
    }

}

