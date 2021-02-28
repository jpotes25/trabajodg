package com.aprendepormi.springbootbackendapirest.models.services;

import java.util.List;

import com.aprendepormi.springbootbackendapirest.models.entity.Multimedia;

public interface IMultimediaService {

	public List<Multimedia> findAll();
	
	public Multimedia findById(Long id);
	
	public Multimedia save (Multimedia multimedia);
	
	public void delete (Long id);
	
}
