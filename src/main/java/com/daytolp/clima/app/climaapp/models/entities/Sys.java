package com.daytolp.clima.app.climaapp.models.entities;

import java.io.Serializable;

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
@Table(name = "sys")
@Entity
public class Sys implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_sys")
	private Integer idSys;
	@Column(name = "id")
	private Integer id;
	@Column(name = "country")
	private String country;
	@Column(name = "sunrise")
	private Integer sunrise;
	@Column(name = "sunset")
	private Integer sunset;
}
