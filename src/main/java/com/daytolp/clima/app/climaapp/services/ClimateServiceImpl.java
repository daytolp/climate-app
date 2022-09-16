package com.daytolp.clima.app.climaapp.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.daytolp.clima.app.climaapp.models.entities.Climate;
import com.daytolp.clima.app.climaapp.models.entities.Weather;
import com.daytolp.clima.app.climaapp.repositories.ClimateRepository;
import com.daytolp.clima.app.climaapp.repositories.CloudsRepository;
import com.daytolp.clima.app.climaapp.repositories.CoordRepository;
import com.daytolp.clima.app.climaapp.repositories.MainRepository;
import com.daytolp.clima.app.climaapp.repositories.SysRepository;
import com.daytolp.clima.app.climaapp.repositories.WeatherRepository;
import com.daytolp.clima.app.climaapp.repositories.WindRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class ClimateServiceImpl implements ClimateService{
	@Value( "${uri.climate}" )
	private String uri;	
	@Value( "${key.secret}" )
	private String key;

	@Autowired
	private ClimateRepository climateRepository;
	@Autowired
	private CloudsRepository cloudsRepository;
	@Autowired
	private CoordRepository coordRepository;
	@Autowired
	private MainRepository mainRepository;
	@Autowired
	private WeatherRepository weatherRepository;
	@Autowired
	private SysRepository sysRepository;
	@Autowired
	private WindRepository windRepository;
	
	@Override
	@Transactional
	public Climate getClimateByCity(String city) throws JsonMappingException, JsonProcessingException {
		String namecity = city.trim();
		Optional<Climate> climateDBOpt = climateRepository.findByName(namecity);
		if (!climateDBOpt.isPresent()) {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Climate> response = restTemplate.getForEntity(this.uri + namecity + this.key, Climate.class);
			
			cloudsRepository.save(response.getBody().getClouds());
			coordRepository.save(response.getBody().getCoord());
			mainRepository.save(response.getBody().getMain());
			windRepository.save(response.getBody().getWind());
			sysRepository.save(response.getBody().getSys());
					
			Climate climate = response.getBody();
			if (climateRepository.findByPetitionNumber().isPresent()) climate.setPetitionNumber(climateRepository.findByPetitionNumber().get() + 1);
			else climate.setPetitionNumber(1);
			climate = climateRepository.save(climate);
			
			List<Weather> weathers = response.getBody().getWeather();
			for (Weather weather : weathers) {
				weather.setClimate(climate);
			}
			
			weatherRepository.saveAll(weathers);
			return climate;
		}
	
		return climateDBOpt.get();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Climate> findByName(String city) {
		return climateRepository.findByName(city);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Climate> findTop10ByOrderByPetitionNumberDesc() {
		return climateRepository.findTop10ByOrderByPetitionNumberDesc();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Long> countClimate() {
		return climateRepository.countClimate();
	}
	
  
	
}
