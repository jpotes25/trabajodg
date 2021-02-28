package com.aprendepormi.springbootbackendapirest.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aprendepormi.springbootbackendapirest.models.entity.Referente;
import com.aprendepormi.springbootbackendapirest.models.services.IReferenteService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ReferenteRestController {

	@Autowired
	private IReferenteService referenteService;
	
	@GetMapping("/referentes")
	public List<Referente> index(){
		return referenteService.findAll();
	}
	
	@GetMapping("/referentes/{id}")
	public Referente show(@PathVariable Long id) {
		return referenteService.findById(id);
	}
	
	@PostMapping("/referentes")
	@ResponseStatus(HttpStatus.CREATED)
	public Referente create(@RequestBody Referente referente) {
		return referenteService.save(referente);
	}
	
	@PutMapping("/referentes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Referente update(@RequestBody Referente referente, @PathVariable Long id) {
		Referente referenteActual = referenteService.findById(id);
		referenteActual.setNombreReferente(referente.getNombreReferente());
		referenteActual.setTituloReferente(referente.getTituloReferente());
		referenteActual.setEnlaceBiografia(referente.getEnlaceBiografia());
		referenteActual.setImagenReferente(referente.getImagenReferente());
		return referenteService.save(referenteActual);
	}
	
	@DeleteMapping("referentes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		referenteService.delete(id);
	}
}
