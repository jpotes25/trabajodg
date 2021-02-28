package com.aprendepormi.springbootbackendapirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendepormi.springbootbackendapirest.models.entity.Actividad;
import com.aprendepormi.springbootbackendapirest.models.dao.IActividadDAO;

@Service
public class ActividadServiceImpl implements IActividadService{

	@Autowired
	private IActividadDAO actividadDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> findAll() {
		
		return (List<Actividad>) actividadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Actividad findById(Long id) {
		
		return actividadDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Actividad save(Actividad actividad) {
		// TODO Apéndice de método generado automáticamente
		return actividadDao.save(actividad);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		actividadDao.deleteById(id);
		
	}

}
