package com.daytolp.clima.app.climaapp.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@Table(name = "climate")
@Entity
public class Climate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_climate")
	private Integer idClimate;
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "base")
	private String base;
	@JoinColumn(name = "id_clouds", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Clouds clouds;
	@Column(name = "cod")
	private Integer cod;
	@JoinColumn(name = "id_coord", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Coord coord;
	@Column(name = "dt")
	private Integer dt;
	@JoinColumn(name = "id_main", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Main main;
	@Column(name = "name")
	private String name;
	@JoinColumn(name = "id_sys", referencedColumnName = "id_sys")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Sys sys;
	@Column(name = "timezone")
	private Integer timezone;
	@Column(name = "visibility")
	private Integer visibility;
	@OneToMany(mappedBy = "climate")
	private List<Weather> weather;
	@JoinColumn(name = "id_wind", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Wind wind;
	@JsonIgnore
	@Column(name = "petition_number")
	private Integer petitionNumber;

}
