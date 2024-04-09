package examenGimnasiosJPA.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import examenGimnasiosJPA.Entidad;

@Entity
@Table(name="gimnasio")
public class Gimnasio extends Entidad implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cómo tiene que crear los nuevos registros
	private int id;
	private String descripcion;
	
	@OneToMany(mappedBy="gimnasio")
	private List<Asistente> asistentes;
	
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

	public List<Asistente> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}

}
