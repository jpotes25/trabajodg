package com.aprendepormi.springbootbackendapirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="ACTIVIDADES")
public class Actividad implements Serializable{

	

	//ATRIBUTOS PROPIOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTIVIDAD")
	private Long idActividad;
	
	@Column(name="NOMBRE_ACTIVIDAD", length = 100)
	private String nombreActividad;
	
	@Column(name="TIPO_ACTIVIDAD", length = 100)
	private String tipoActividad;
	
	@Column(name="AUTOR_ACTIVIDAD", length = 100)
	private String autorActividad;
	
	@Column(name="ENLACE_ACTIVIDAD", length = 100)
	private String enlaceActividad;

	// FIN ATRIBUTOS PROPIOS
	
	//RELACION DIFICULTAD
	
		@ManyToMany(mappedBy="actividades")
				private List<Dificultad> dificultad ;
		
	//METODOS DIFICULTAD
		
		public void setDificultad(List<Dificultad> dificultad) {
			this.dificultad = dificultad;
		}
	
	//FIN RELACION DIFICULTAD
		
	// GETTERS AND SETTERS PROPIOS
	public long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(long idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getAutorActividad() {
		return autorActividad;
	}

	public void setAutorActividad(String autorActividad) {
		this.autorActividad = autorActividad;
	}

	public String getEnlaceActividad() {
		return enlaceActividad;
	}

	public void setEnlaceActividad(String enlaceActividad) {
		this.enlaceActividad = enlaceActividad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Actividad)) {
			return false;
		}
 
		Actividad a = (Actividad) obj;
		
		return this.idActividad != null && this.idActividad.equals(a.getIdActividad());
	}
	
	// FIN GETTERS AND SETTERS PROPIOS
	
	// ATRIBUTO INTERFAZ SERIALIZABLE
	
	private static final long serialVersionUID = 1L;
}
