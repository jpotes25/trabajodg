package com.aprendepormi.springbootbackendapirest.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aprendepormi.springbootbackendapirest.models.entity.Referente;
import com.aprendepormi.springbootbackendapirest.models.dao.IReferenteDAO;

@Service
public class ReferenteServiceImpl implements IReferenteService {
	
	@Autowired
	private IReferenteDAO referenteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Referente> findAll() {
		// TODO Apéndice de método generado automáticamente
		return (List<Referente>) referenteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Referente findById(Long id) {
		// TODO Apéndice de método generado automáticamente
		return referenteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Referente save(Referente referente) {
		// TODO Apéndice de método generado automáticamente
		return referenteDao.save(referente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Apéndice de método generado automáticamente
		referenteDao.deleteById(id);
		
	}

	
}
