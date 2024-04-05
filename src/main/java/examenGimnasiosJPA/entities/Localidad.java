package examenGimnasiosJPA.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import examenGimnasiosJPA.Entidad;


@Entity
@Table(name="localidad")
public class Localidad extends Entidad implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String localidad;

	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="idlocalidad")
	private Localidad localidadObj;
	
	public Localidad() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Localidad getLocalidadObj() {
		return localidadObj;
	}

	public void setLocalidadObj(Localidad localidadObj) {
		this.localidadObj = localidadObj;
	}
	
}
