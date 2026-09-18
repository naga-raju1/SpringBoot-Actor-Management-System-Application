package com.spring.boot.ams.controller;


import com.spring.boot.ams.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.spring.boot.ams.model.Actor;
import com.spring.boot.ams.responsestructure.ResponseStructure;

@AllArgsConstructor
@RestController
public class ActorController
{
    private ActorService service;

    @PostMapping("/actors")
    public ResponseEntity<ResponseStructure<Actor>> createActor(@RequestBody Actor actor)
    {
        Actor savedActor = service.addActor(actor);
        ResponseStructure<Actor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Actors Created Successfully");
        rs.setData(savedActor);
        return new ResponseEntity<ResponseStructure<Actor>>(rs, HttpStatus.CREATED);
    }

    @GetMapping("/actors")
    public  ResponseEntity<ResponseStructure<List<Actor>>> displayAllActors()
    {
         List<Actor> display = service.findAllActors();
         ResponseStructure<List<Actor>> rs = new ResponseStructure<>();
         rs.setStatusCode(HttpStatus.FOUND.value());
         rs.setMessage("Actors are found successfully");
         rs.setData(display);
         return new ResponseEntity<ResponseStructure<List<Actor>>>(rs, HttpStatus.FOUND);
    }

    @GetMapping("/actior/id/{id}")
    public ResponseEntity<ResponseStructure<Actor>> findActorById(@PathVariable("id") int actorId)
    {
        Actor actor = service.findActorById(actorId);
        ResponseStructure<Actor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("Actor Found Successfully");
        rs.setData(actor);
        return new ResponseEntity<ResponseStructure<Actor>>(rs, HttpStatus.FOUND);
    }

    @PutMapping("/actor/id/{id}")
    public ResponseEntity<ResponseStructure<Actor>> updateActorById(@PathVariable("id") int actorId,@RequestBody Actor updatedActor)
    {
        Actor actor = service.updateActor(actorId, updatedActor);
        ResponseStructure<Actor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Actor Updated Successfully");
        rs.setData(actor);
        return new ResponseEntity<ResponseStructure<Actor>>(rs, HttpStatus.CREATED);

    }

    @DeleteMapping("/actor/id/{id}")
    public ResponseEntity<ResponseStructure<Actor>> deleteActorById(@PathVariable("id") int actorId)
    {
        Actor actor = service.removeActorById(actorId);
        ResponseStructure<Actor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Actor Deleted Successfully");
        rs.setData(actor);
        return new ResponseEntity<ResponseStructure<Actor>>(rs, HttpStatus.OK);
    }

    @GetMapping("/actors/name/{name}")
    public ResponseEntity<ResponseStructure<List<Actor>>> displayActorByName(@PathVariable("name") String actor_name)
    {
        List<Actor> actor = service.fetchActorByName(actor_name);
        ResponseStructure<List<Actor>> rs = new ResponseStructure<List<Actor>>();
        rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("Actors Found Successfully");
        rs.setData(actor);
        return new ResponseEntity<ResponseStructure<List<Actor>>>(rs, HttpStatus.FOUND);
    }

    @GetMapping("/actors/industry/{industry}")
    public ResponseEntity<ResponseStructure<List<Actor>>> displayActorByIndustry(@PathVariable("industry") String industry)
    {
        List<Actor> actor = service.fetchActorByIndustry(industry);
        ResponseStructure<List<Actor>> rs = new ResponseStructure<List<Actor>>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Actors Found Successfully");
        rs.setData(actor);
        return new ResponseEntity<ResponseStructure<List<Actor>>>(rs, HttpStatus.OK);
    }

    @GetMapping("/actors/age/{age}")
    public  ResponseEntity<ResponseStructure<List<Actor>>> displayActorByAge(@PathVariable("age") int age)
    {
        List<Actor> actor = service.fetchActorByAge(age);
        ResponseStructure<List<Actor>> rs = new ResponseStructure<List<Actor>>();
        rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("Actors Found Successfully");
        rs.setData(actor);
        return new ResponseEntity<ResponseStructure<List<Actor>>>(rs, HttpStatus.OK);
    }

}
