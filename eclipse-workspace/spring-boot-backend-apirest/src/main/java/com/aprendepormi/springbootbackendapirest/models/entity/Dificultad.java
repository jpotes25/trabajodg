package com.aprendepormi.springbootbackendapirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="dificultades")
public class Dificultad implements Serializable {

	
	
	

	//ATRIBUTOS PROPIOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_dificultad")
	private long idDificultad;
	@Column(name = "nombre_dificultad")
	private String nombreDificultad;
	@Column(columnDefinition = "TEXT", name = "que_es")
	private String QueEs;
	@Column(columnDefinition = "TEXT", name = "como_identificarlo")
	private String ComoIdentificarlo;
	@Column(name="enlace_slider")
	private String enlaceSlider;
	
	//FIN ATRIBUTOS PROPIOS
	
	
	//RELACION TABLA REFERENTES
	@JoinTable(name="Dificultad_Referentes"
			,joinColumns=@JoinColumn(name="id_dificultad")
			,inverseJoinColumns=@JoinColumn(name="id_referente"))
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
	
	private List<Referente> referentes;
	
	public void agregarReferente(Referente referentes) {
		if(this.referentes == null) {
			this.referentes = new ArrayList<>();
		}
		this.referentes.add(referentes);
	}
	
	public void deleteReferente(Referente referentes) {
		this.referentes.remove(referentes);
		referentes.setDificultad(null);
	}

	//FIN RELACION REFERENTES
	
	
	//RELACION TABLA ACTIVIDADES
	@JoinTable(name="Dificultad_Actividad"
			,joinColumns=@JoinColumn(name="id_dificultad")
			,inverseJoinColumns=@JoinColumn(name="id_actividad"))
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
	
	private List<Actividad> actividades;
	
	public List<Referente> getReferentes() {
		return referentes;
	}

	public void setReferentes(List<Referente> referentes) {
		this.referentes = referentes;
	}

	public void agregarActividad(Actividad actividad) {
		if(this.actividades == null) {
			this.actividades = new ArrayList<>();
		}
		this.actividades.add(actividad);
	}
	
	public void deleteActividad (Actividad actividad) {
		this.actividades.remove(actividad);
		actividad.setDificultad(null);
	}
	
	//FIN RELACION ACTIVIDADES
	
	// RELACION TABLA MULTIMEDIA
	
			@JoinTable(name = "Dificultad_Multimedia"
					
					,joinColumns = @JoinColumn(name="id_Dificultad")
					, inverseJoinColumns = @JoinColumn(name="id_multimedia")
					)
			
			@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
			private List<Multimedia> multimedia;
				
			public void agregarMultimedia(Multimedia multimedia) {
				if(this.multimedia == null) {
					this.multimedia = new ArrayList<>();
				}
				this.multimedia.add(multimedia);
			}
			
			public void deleteMultimedia (Multimedia multimedia) {
				this.multimedia.remove(multimedia);
				multimedia.setDificultad(null);
			}
			
		
			
			// FIN RELACION MULTIMEDIA
			
			// GETTERS AND SETTERS MULTIMEDIA
			public List<Multimedia> getMultimedia() {
				return multimedia;
			}

			public void setMultimedia(List<Multimedia> multimedia) {
				this.multimedia = multimedia;
			}
			//FIN GETTERS AND SETTERS MULTIMEDIA
	
	//GETTERS AND SETTERS ACTIVIDADES
	public List<Actividad> getActividad() {
		return actividades;
	}

	public void setActividad(List<Actividad> actividad) {
		this.actividades = actividad;
	}

	// FIN GETTERS AND SETTERS ACTIVIDADES
	
	
	//GETTERS AND SETTERS PROPIOS
	public String getNombreDificultad() {
		return nombreDificultad;
	}

	public void setNombreDificultad(String nombreDificultad) {
		this.nombreDificultad = nombreDificultad;
	}
	
	public long getIdDificultad() {
		return idDificultad;
	}


	public void setIdDificultad(long idDificultad) {
		this.idDificultad = idDificultad;
	}

	public String getQueEs() {
		return QueEs;
	}

	public void setQueEs(String queEs) {
		QueEs = queEs;
	}

	public String getComoIdentificarlo() {
		return ComoIdentificarlo;
	}

	public void setComoIdentificarlo(String comoIdentificarlo) {
		ComoIdentificarlo = comoIdentificarlo;
	}
	
	public String getEnlaceSlider() {
		return enlaceSlider;
	}

	public void setEnlaceSlider(String enlaceSlider) {
		this.enlaceSlider = enlaceSlider;
	}

	//FIN GETTERS AND SETTERS PROPIOS
	//ATRIBUTO INTERFAZ SERIALIZABLE
	private static final long serialVersionUID = 1L;
	
}
