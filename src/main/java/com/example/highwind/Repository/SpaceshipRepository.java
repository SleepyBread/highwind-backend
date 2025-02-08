package com.example.highwind.Repository;

import com.example.highwind.Entity.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, Integer> {

}
