package com.daytolp.clima.app.climaapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daytolp.clima.app.climaapp.models.entities.Coord;

public interface CoordRepository  extends JpaRepository<Coord, Integer>{

}
