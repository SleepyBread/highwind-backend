package com.example.highwind;

import com.example.highwind.Entity.Spaceship;
import com.example.highwind.Repository.SpaceshipRepository;
import com.example.highwind.Service.SpaceshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestApi {

    @Autowired
    private SpaceshipService spaceshipService;

    @PostMapping("/spaceship/new")
    public ResponseEntity<Spaceship> createSpaceship(
            @RequestBody Spaceship spaceship
    ) {

        try{

            return ResponseEntity.ok(spaceshipService.createSpaceship(
                    spaceship.getMasse(),
                    spaceship.getX(),
                    spaceship.getY(),
                    spaceship.getSurfaceVoile(),
                    spaceship.getAngleVoile()
            ));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/spaceship/{id}")
    public ResponseEntity<Spaceship> updateSpaceship(
            @PathVariable int id,
            @RequestBody Spaceship spaceship
    ) {
        try {
            if (spaceship == null) {
                throw new IllegalArgumentException("Missing required parameters");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        try{

            Spaceship existingSpaceship = spaceshipService.getSpaceship(id);
            if (existingSpaceship == null) {
                return ResponseEntity.notFound().build();
            }

            existingSpaceship.setMasse(spaceship.getMasse());
            existingSpaceship.setX(spaceship.getX());
            existingSpaceship.setY(spaceship.getY());
            existingSpaceship.setSurfaceVoile(spaceship.getSurfaceVoile());
            existingSpaceship.setAngleVoile(spaceship.getAngleVoile());

            spaceshipService.updateSpaceship(existingSpaceship);

            return ResponseEntity.ok(existingSpaceship);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/spaceship/{id}")
    public ResponseEntity<Spaceship> getSpaceship(
            @PathVariable int id
    ) {
        try{
            System.out.println(id);
            Spaceship spaceship = spaceshipService.getSpaceship(id);

            System.out.println(spaceship);


            return ResponseEntity.ok(spaceship);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/spaceship/{id}")
    public ResponseEntity<Spaceship> deleteSpaceship(
            @PathVariable int id
    ) {
        try{
            spaceshipService.deleteSpaceship(id);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
