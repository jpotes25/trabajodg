package com.aprendepormi.springbootbackendapirest.models.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="multimedia")
public class Multimedia implements Serializable {

	
	//ATRIBUTOS PROPIOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_multimedia")
	private Long idMultimedia;
	
	@Column(name= "nombre_multimedia", length = 100)
	private String nombreMultimedia;
	
	@Column(name= "tipo_multimedia", length = 100)
	private String tipoMultimedia;
	
	@Column(name= "enlace_multimedia", length = 100)
	private String enlaceMultimedia;
	
	//FIN ATRIBUTOS PROPIOS

	
	//RELACION TABLA ACTIVIDAD
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Multimedia_Actividad"
			
			,joinColumns = @JoinColumn(name="id_multimedia")
			, inverseJoinColumns = @JoinColumn(name="id_actividad")
			)
	private Set<Actividad> actividad;
	
	//FIN RELACION ACTIVIDAD

	// GETTERS AND SETTERS ACTIVIDAD
	public Set<Actividad> getActividad() {
		return actividad;
	}

	public void setActividad(Set<Actividad> actividad) {
		this.actividad = actividad;
	}
	
	// FIN GETTERS AND SETTERS ACTIVIDAD
	
	//relacion dificultad
	
	@ManyToMany(mappedBy="multimedia")
			private List<Dificultad> dificultad ;
	
	
	//GETTERS AND SETTERS PROPIOS
	
	public void setDificultad(List<Dificultad> dificultad) {
		this.dificultad = dificultad;
	}
	public long getIdMultimedia() {
		return idMultimedia;
	}

	public void setIdMultimedia(long idMultimedia) {
		this.idMultimedia = idMultimedia;
	}

	public String getNombreMultimedia() {
		return nombreMultimedia;
	}

	public void setNombreMultimedia(String nombreMultimedia) {
		this.nombreMultimedia = nombreMultimedia;
	}

	public String getTipoMultimedia() {
		return tipoMultimedia;
	}

	public void setTipoMultimedia(String tipoMultimedia) {
		this.tipoMultimedia = tipoMultimedia;
	}

	public String getEnlaceMultimedia() {
		return enlaceMultimedia;
	}

	public void setEnlaceMultimedia(String enlaceMultimedia) {
		this.enlaceMultimedia = enlaceMultimedia;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Multimedia)) {
			return false;
		}
 
		Multimedia a = (Multimedia) obj;
		
		return this.idMultimedia != null && this.idMultimedia.equals(a.getIdMultimedia());
	}
	// FIN GETTERS AND SETTERS PROPIOS
	
	//ATRIBUTO INTERFAZ SERIALIZABLE

	private static final long serialVersionUID = 1L;

}
