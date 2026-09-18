package com.spring.boot.ams.service;

import com.spring.boot.ams.model.Actor;
import java.util.List;


public interface ActorService
{

    Actor addActor(Actor actor);

    List<Actor> findAllActors();

    Actor findActorById(int actorId);

    Actor updateActor(int actorId, Actor updatedActor);

    Actor removeActorById(int actorId);

    List<Actor> fetchActorByName(String actor_name);

    List<Actor> fetchActorByIndustry(String industry);

    List<Actor> fetchActorByAge(int age);
}
