package com.aprendepormi.springbootbackendapirest.models.services;

import java.util.List;
import com.aprendepormi.springbootbackendapirest.models.entity.Referente;
public interface IReferenteService {

	public List<Referente> findAll();
	public Referente findById(Long id);
	public Referente save (Referente referente);
	public void delete (Long id);
}
