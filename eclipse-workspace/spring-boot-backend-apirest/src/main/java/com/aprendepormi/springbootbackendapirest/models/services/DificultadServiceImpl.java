package com.aprendepormi.springbootbackendapirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendepormi.springbootbackendapirest.models.dao.IDificultadDAO;
import com.aprendepormi.springbootbackendapirest.models.entity.Actividad;
import com.aprendepormi.springbootbackendapirest.models.entity.Dificultad;
import com.aprendepormi.springbootbackendapirest.models.entity.Multimedia;
import com.aprendepormi.springbootbackendapirest.models.entity.Referente;

@Service
public class DificultadServiceImpl implements IDificultadService{
	@Autowired
	private IDificultadDAO dificultadDao;
	@Override
	@Transactional(readOnly = true)
	public List<Dificultad> findAll() {
		// TODO Auto-generated method stub
		
		return (List<Dificultad>) dificultadDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Dificultad findById(Long id) {
		// TODO Auto-generated method stub
		return dificultadDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public Dificultad save(Dificultad dificultad) {
		// TODO Auto-generated method stub
		return dificultadDao.save(dificultad);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dificultadDao.deleteById(id);
	}
	@Override
	@Transactional
	public void deleteMult(Multimedia multimedia) {
		List<Dificultad> dif = (List<Dificultad>) dificultadDao.findAll();
		for (Long i=(long) 1;i<=dif.size();i++) {
			
			Dificultad dificultadl = dificultadDao.findById(i).get();
			List<Multimedia> lista = dificultadl.getMultimedia();
			if(!lista.isEmpty()) {
				for(int k= 0; k<=dificultadl.getMultimedia().size(); k++) {
					dificultadl.getMultimedia().remove(multimedia);
					multimedia.setDificultad(null);
						
				}
					
			}else {
			
			}
	
			
		}
	}
	
	@Override
	@Transactional
	public void deleteActividad(Actividad actividad) {
		List<Dificultad> dif = (List<Dificultad>) dificultadDao.findAll();
		for (Long i=(long) 1;i<=dif.size();i++) {
			
			Dificultad dificultadl = dificultadDao.findById(i).get();
			List<Actividad> lista = dificultadl.getActividad();
			if(!lista.isEmpty()) {
				for(int k= 0; k<=dificultadl.getActividad().size(); k++) {
					dificultadl.getActividad().remove(actividad);
					actividad.setDificultad(null);
						
				}
					
			}else {
			
			}
	
			
		}
	}
	
	@Override
	@Transactional
	public void deleteReferente(Referente referente) {
		List<Dificultad> dif = (List<Dificultad>) dificultadDao.findAll();
		for (Long i=(long) 1;i<=dif.size();i++) {
			
			Dificultad dificultadl = dificultadDao.findById(i).get();
			List<Referente> lista = dificultadl.getReferentes();
			if(!lista.isEmpty()) {
				for(int k= 0; k<=dificultadl.getReferentes().size(); k++) {
					dificultadl.getReferentes().remove(referente);
					referente.setDificultad(null);
						
				}
					
			}else {
			
			}
	
			
		}
	}

}
