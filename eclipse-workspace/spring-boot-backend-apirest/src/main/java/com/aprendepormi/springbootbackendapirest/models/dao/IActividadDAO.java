package com.aprendepormi.springbootbackendapirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aprendepormi.springbootbackendapirest.models.entity.Actividad;

public interface IActividadDAO extends CrudRepository<Actividad, Long>{

}
