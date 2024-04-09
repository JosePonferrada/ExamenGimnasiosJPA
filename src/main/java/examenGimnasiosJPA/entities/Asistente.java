package examenGimnasiosJPA.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="asistente")
public class Asistente extends Entidad implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cómo tiene que crear los nuevos registros
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="idgimnasio")
	private Gimnasio gimnasio;
	
	private String dniNiePasaporte;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="idlocalidad")
	private Localidad localidadObj;

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

	public String getDniNiePasaporte() {
		return dniNiePasaporte;
	}

	public void setDniNiePasaporte(String dniNiePasaporte) {
		this.dniNiePasaporte = dniNiePasaporte;
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

	public Localidad getLocalidadObj() {
		return localidadObj;
	}

	public void setLocalidadObj(Localidad localidadObj) {
		this.localidadObj = localidadObj;
	}

	public Gimnasio getGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
	}
	

	
}
