package com.daytolp.clima.app.climaapp.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@Table(name = "main")
@Entity
public class Main implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "feels_like")
	private BigDecimal feels_like;
	@Column(name = "humidity")
	private Integer humidity;
	@Column(name = "pressure")
	private Integer pressure;
	@Column(name = "temp")
	private BigDecimal temp;
	@Column(name = "temp_max")
	private BigDecimal temp_max;
	@Column(name = "temp_min")
	private BigDecimal temp_min;
	@Column(name = "grnd_level")
	private Integer grnd_level;
	@Column(name = "sea_level")
	private Integer sea_level;

}
