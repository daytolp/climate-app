package com.daytolp.clima.app.climaapp.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

import com.daytolp.clima.app.climaapp.models.entities.Climate;
import com.daytolp.clima.app.climaapp.services.ClimateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/")
public class ClimateController {
    @Autowired
    ClimateService climateService;

    @GetMapping(value = "check-weather")
    public ResponseEntity<?> getClimateByCity(@RequestParam(required = true) String city) {
    	if(city.trim().isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("mensaje", "La ciudad no debe venir vacía."));
    	Climate climate = null;
        try {
        	climate = climateService.getClimateByCity(city);
        } catch (HttpStatusCodeException e) {
        	log.info("error:"+ e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error en la petición.");
		}catch(ResourceAccessException e) {
			log.info("error:"+ e.getMessage());
			Optional<Climate> climateOpt = climateService.findByName(city);
			if(climateOpt.isPresent()) return ResponseEntity.ok(climateOpt.get());			
			return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Error al establecer conexión con OpenWeather API.");
		} catch (Exception e) {
        	log.info("error:"+ e.getMessage());
			return new ResponseEntity<>("Error del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(climate);
    }
    
    @GetMapping(value = "check-weather-top")
    public ResponseEntity<?> getClimatesTop10() {
    	List<Climate> climates = new ArrayList<>();
    	Map<String, Object> response = new HashMap<>();
        try {
        	climates = climateService.findTop10ByOrderByPetitionNumberDesc();
        	response.put("top10", climates);
        	response.put("numberQuerys", climateService.countClimate());
        } catch (HttpStatusCodeException e) {
        	log.info("error:"+ e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error en la petición.");
		}catch(ResourceAccessException e) {
			log.info("error:"+ e.getMessage());		
			return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Error al establecer conexión con OpenWeather API.");
		} catch (Exception e) {
        	log.info("error:"+ e.getMessage());
			return new ResponseEntity<>("Error del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);
    }
}
