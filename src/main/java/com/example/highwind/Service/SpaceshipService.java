package com.example.highwind.Service;

import com.example.highwind.Entity.Spaceship;
import com.example.highwind.Repository.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SpaceshipService {
    private SpaceshipRepository spaceshipRepository;

    public SpaceshipService(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public Spaceship createSpaceship(
            long masse,
            long x,
            long y,
            int surfaceVoile,
            float angleVoile
    ) {
        Spaceship spaceship = new Spaceship(masse, x, y, surfaceVoile, angleVoile);

       return spaceshipRepository.save(spaceship);
    }

    public void updateSpaceship(Spaceship spaceship) {
        spaceshipRepository.save(spaceship);
    }

    public void deleteSpaceship(int id) {
        spaceshipRepository.deleteById(id);
    }

    public Spaceship getSpaceship(int id) {
        return spaceshipRepository.findById(id).orElse(null);
    }
}
