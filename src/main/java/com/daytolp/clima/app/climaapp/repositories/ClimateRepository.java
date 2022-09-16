package com.daytolp.clima.app.climaapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daytolp.clima.app.climaapp.models.entities.Climate;

public interface ClimateRepository extends JpaRepository<Climate, Integer>{
	public abstract Optional<Climate> findByName(String city);

	@Query(value =	"select max(petition_number) from climate", nativeQuery =true)
	public abstract Optional<Integer> findByPetitionNumber();
	
	public abstract List<Climate> findTop10ByOrderByPetitionNumberDesc();
	
	@Query(value =	"select count(*) from climate", nativeQuery =true)
	public abstract Optional<Long> countClimate();
}
