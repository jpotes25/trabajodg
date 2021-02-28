package com.aprendepormi.springbootbackendapirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aprendepormi.springbootbackendapirest.models.entity.Referente;


public interface IReferenteDAO  extends CrudRepository<Referente, Long>{

}
