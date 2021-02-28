package com.aprendepormi.springbootbackendapirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aprendepormi.springbootbackendapirest.models.entity.Dificultad;

public interface IDificultadDAO extends CrudRepository<Dificultad, Long>{
	
	
}
