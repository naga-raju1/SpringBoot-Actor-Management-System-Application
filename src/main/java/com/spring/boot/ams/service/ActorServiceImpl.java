package com.spring.boot.ams.service;

import com.spring.boot.ams.exception.ActorNotFoundByIdException;
import com.spring.boot.ams.exception.ActorNotFoundByNameException;
import com.spring.boot.ams.exception.ActorNotFoundException;
import com.spring.boot.ams.model.Actor;
import com.spring.boot.ams.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService
{
    private final ActorRepository repository;



    @Override
    public Actor addActor(Actor actor) {
        return repository.save(actor);
    }

    @Override
    public List<Actor> findAllActors() {
        List<Actor> actors = repository.findAll();
        if (actors.isEmpty()) {
            throw new ActorNotFoundException("Actors Not Found");
        }else{
            return actors;
        }
    }

    @Override
    public Actor findActorById(int actorId) {
        Optional<Actor> optional = repository.findById(actorId);
        if(optional.isEmpty()){
            throw new ActorNotFoundByIdException("Actor Not Found");
        }else {
            return optional.get();
        }
    }

    @Override
    public Actor updateActor(int actorId, Actor updatedActor) {
        Optional<Actor> optional= repository.findById(actorId);
        if (optional.isEmpty()){
            throw new ActorNotFoundByIdException("Actor Not Found");
        }else  {
            Actor existingactor = optional.get();
            updatedActor.setId(existingactor.getId());
            return repository.save(updatedActor);
        }
    }

    @Override
    public Actor removeActorById(int actorId) {
        Optional<Actor> optional= repository.findById(actorId);
        if (optional.isEmpty()){
            throw new ActorNotFoundByIdException("Actor Not Found");
        }
        Actor existActor = optional.get();
        repository.delete(existActor);
        return existActor;
    }

    @Override
    public List<Actor> fetchActorByName(String actor_name) {
        List<Actor> actor = repository.findActorByName(actor_name);
        if (actor.isEmpty()) {
            throw new ActorNotFoundByNameException("Actors Not Found");
        }else  {
            return actor;
        }
    }

    @Override
    public List<Actor> fetchActorByIndustry(String industry) {
        List<Actor> actor = repository.findActorByIndustry(industry);
        if (actor.isEmpty()) {
            throw new ActorNotFoundException("Actors Not Found");
        }else  {
            return actor;
        }
    }

    @Override
    public List<Actor> fetchActorByAge(int age) {
        List<Actor> actor = repository.findActorByAge(age);
        if (actor.isEmpty()) {
            throw new ActorNotFoundException("Actors Not Found");
        }else   {
            return actor;
        }
    }
}
