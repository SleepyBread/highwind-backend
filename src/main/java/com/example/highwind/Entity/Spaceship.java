package com.example.highwind.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "spaceship")
public class Spaceship {
    public Spaceship() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "Masse", nullable = false)
    private Long masse;

    @ColumnDefault("0")
    @Column(name = "X", nullable = false)
    private Long x;

    @ColumnDefault("0")
    @Column(name = "Y", nullable = false)
    private Long y;

    @ColumnDefault("0")
    @Column(name = "SurfaceVoile", nullable = false)
    private Integer surfaceVoile;

    @ColumnDefault("0")
    @Column(name = "AngleVoile", nullable = false)
    private Float angleVoile;

    public Spaceship(Long masse, Long x, Long y, Integer surfaceVoile, Float angleVoile) {
        this.masse = masse;
        this.x = x;
        this.y = y;
        this.surfaceVoile = surfaceVoile;
        this.angleVoile = angleVoile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMasse() {
        return masse;
    }

    public void setMasse(Long masse) {
        this.masse = masse;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Integer getSurfaceVoile() {
        return surfaceVoile;
    }

    public void setSurfaceVoile(Integer surfaceVoile) {
        this.surfaceVoile = surfaceVoile;
    }

    public Float getAngleVoile() {
        return angleVoile;
    }

    public void setAngleVoile(Float angleVoile) {
        this.angleVoile = angleVoile;
    }

}