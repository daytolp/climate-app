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
@Table(name = "wind")
@Entity
public class Wind implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;
	@Column(name="deg")
	private BigDecimal deg;
	@Column(name="speed")
	private BigDecimal speed;
	@Column(name="gust")
	private BigDecimal gust;
}
