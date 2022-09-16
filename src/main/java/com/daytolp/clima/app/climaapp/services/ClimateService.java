package com.daytolp.clima.app.climaapp.services;

import java.util.List;
import java.util.Optional;

import com.daytolp.clima.app.climaapp.models.entities.Climate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ClimateService {
	public abstract Climate getClimateByCity(String city) throws JsonMappingException, JsonProcessingException;
	public abstract Optional<Climate> findByName(String city);
	public abstract List<Climate> findTop10ByOrderByPetitionNumberDesc();
	public abstract Optional<Long> countClimate();
}
