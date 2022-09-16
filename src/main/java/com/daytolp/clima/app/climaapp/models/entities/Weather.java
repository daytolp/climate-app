package com.daytolp.clima.app.climaapp.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@Table(name = "weather")
@Entity
public class Weather  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "description")
	private String description;
	@Column(name = "icon")
	private String icon;
	@Column(name = "main")
	private String  main;
	@JsonIgnore
	@ManyToOne
	private Climate climate;
}
