package examenGimnasiosJPA.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import examenGimnasiosJPA.Entidad;


@Entity
@Table(name="asistente")
public class Asistente extends Entidad implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cómo tiene que crear los nuevos registros
	private int id;
	@OneToMany(mappedBy="gimnasio")
	private List<Gimnasio> gimnasios;
	
	private String dniNiePasaporte;
	
	@OneToMany(mappedBy="gimnasio")
	private List<Localidad> localidades;
	
	private Boolean activo;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private Float cuotaMensual;

	public Asistente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Gimnasio> getGimnasios() {
		return gimnasios;
	}

	public void setGimnasios(List<Gimnasio> gimnasios) {
		this.gimnasios = gimnasios;
	}

	public String getDniNiePasaporte() {
		return dniNiePasaporte;
	}

	public void setDniNiePasaporte(String dniNiePasaporte) {
		this.dniNiePasaporte = dniNiePasaporte;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Float getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(Float cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}
	

	
}
