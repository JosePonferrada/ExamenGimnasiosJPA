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
@Table(name="gimnasio")
public class Gimnasio extends Entidad implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cómo tiene que crear los nuevos registros
	private int id;
	private String descripcion;

	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="idgimnasio")
	private Gimnasio gimnasio;
	
	public Gimnasio() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Gimnasio getGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
	}

}
