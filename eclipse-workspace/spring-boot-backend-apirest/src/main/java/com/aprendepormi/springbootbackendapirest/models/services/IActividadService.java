package com.aprendepormi.springbootbackendapirest.models.services;

import java.util.List;

import com.aprendepormi.springbootbackendapirest.models.entity.Actividad;


public interface IActividadService {

	public List<Actividad> findAll();
	
	public Actividad findById(Long id);
	
	public Actividad save (Actividad multimedia);
	
	public void delete (Long id);
}
