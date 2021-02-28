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
@Table (name="REFERENTES")
public class Referente implements Serializable {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_REFERENTE")
	private Long idReferente;
	
	@Column(name= "NOMBRE_REFERENTE", length = 100)
	private String nombreReferente;
	
	@Column(name= "TITULO_REFERENTE", length = 100)
	private String tituloReferente;
	
	@Column(name= "BIOGRAFIA_REFERENTE", length = 100)
	private String enlaceBiografia;
	
	@Column(name= "IMAGEN_REFERENTE", length = 100)
	private String imagenReferente;

	//FIN ATRIBUTOS PROPIOIS
	
	//RELACION DIFICULTAD
	
			@ManyToMany(mappedBy="referentes")
					private List<Dificultad> dificultad ;
			
		//METODOS DIFICULTAD
			
			public void setDificultad(List<Dificultad> dificultad) {
				this.dificultad = dificultad;
			}
		
		//FIN RELACION DIFICULTAD

	//GETTERS AND SETTERS
	public long getIdReferente() {
		return idReferente;
	}

	public void setIdReferente(long idReferente) {
		this.idReferente = idReferente;
	}

	public String getNombreReferente() {
		return nombreReferente;
	}

	public void setNombreReferente(String nombreReferente) {
		this.nombreReferente = nombreReferente;
	}

	public String getImagenReferente() {
		return imagenReferente;
	}

	public void setImagenReferente(String imagenReferente) {
		this.imagenReferente = imagenReferente;
	}

	public String getTituloReferente() {
		return tituloReferente;
	}

	public void setTituloReferente(String tituloReferente) {
		this.tituloReferente = tituloReferente;
	}

	public String getEnlaceBiografia() {
		return enlaceBiografia;
	}

	public void setEnlaceBiografia(String enlaceBiografia) {
		this.enlaceBiografia = enlaceBiografia;
	}
	
	//FIN GETTERS AND SETTERS
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Referente)) {
			return false;
		}
 
		Referente a = (Referente) obj;
		
		return this.idReferente != null && this.idReferente.equals(a.getIdReferente());
	}

	//ATRIBUTO INTERFAZ SERIALIZABLE

	private static final long serialVersionUID = 1L;

}
