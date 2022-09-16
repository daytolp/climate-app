package com.daytolp.clima.app.climaapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daytolp.clima.app.climaapp.models.entities.Wind;

public interface WindRepository extends JpaRepository<Wind, Integer>{

}
