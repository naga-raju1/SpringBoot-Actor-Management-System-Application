package com.spring.boot.ams.repository;

import com.spring.boot.ams.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer>
{
    List<Actor> findActorByName(String actor_name);

    List<Actor> findActorByIndustry(String industry);

    List<Actor> findActorByAge(int age);
}
