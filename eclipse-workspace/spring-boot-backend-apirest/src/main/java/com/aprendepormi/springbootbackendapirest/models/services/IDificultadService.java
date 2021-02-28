package com.aprendepormi.springbootbackendapirest.models.services;

import java.util.List;

import com.aprendepormi.springbootbackendapirest.models.entity.Actividad;
import com.aprendepormi.springbootbackendapirest.models.entity.Dificultad;
import com.aprendepormi.springbootbackendapirest.models.entity.Multimedia;
import com.aprendepormi.springbootbackendapirest.models.entity.Referente;

public interface IDificultadService {

	public List<Dificultad> findAll();
	
	public Dificultad findById(Long id);
	
	public Dificultad save (Dificultad dificultad);
	
	public void delete (Long id);
	
	public void deleteMult (Multimedia multimedia);
	
	public void deleteActividad (Actividad actividad);
	
	public void deleteReferente (Referente referente);
	
	
}
