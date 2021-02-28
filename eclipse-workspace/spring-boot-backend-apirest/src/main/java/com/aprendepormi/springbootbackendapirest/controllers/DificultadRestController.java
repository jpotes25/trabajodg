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

import com.aprendepormi.springbootbackendapirest.models.entity.Actividad;
import com.aprendepormi.springbootbackendapirest.models.entity.Dificultad;
import com.aprendepormi.springbootbackendapirest.models.entity.Multimedia;
import com.aprendepormi.springbootbackendapirest.models.entity.Referente;
import com.aprendepormi.springbootbackendapirest.models.services.IDificultadService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class DificultadRestController {
	
	@Autowired
	private IDificultadService dificultadService;
	
	
	@GetMapping("/dificultad")
	public List<Dificultad> index(){
		return dificultadService.findAll();
	}
	
	@GetMapping("/dificultad/{id}")
	public Dificultad show(@PathVariable Long id) {
		
	return dificultadService.findById(id);
	
	}
	
	@PostMapping("/dificultad")
	@ResponseStatus(HttpStatus.CREATED)
	public Dificultad create(@RequestBody Dificultad dificultad) {
		return dificultadService.save(dificultad);
	}
	
	
	@PutMapping("/dificultad/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Dificultad update(@RequestBody Dificultad dificultad, @PathVariable Long id) {
		Dificultad dificultadActual = dificultadService.findById(id);
		dificultadActual.setNombreDificultad(dificultad.getNombreDificultad());
		dificultadActual.setQueEs(dificultad.getQueEs());
		dificultadActual.setComoIdentificarlo(dificultad.getComoIdentificarlo());
		if(dificultad.getEnlaceSlider() != null) {
		dificultadActual.setEnlaceSlider(dificultad.getEnlaceSlider());
		}
		return dificultadService.save(dificultadActual);
	}
	
	@DeleteMapping("/dificultad/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		dificultadService.delete(id);
	}
	
	//MULTIMEDIA
	@DeleteMapping("/dificultad/deletem")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletem(@RequestBody Multimedia multimedia) {
		dificultadService.deleteMult(multimedia);
	}
	
	
	@PutMapping("/dificultad/asign/{idDificultad}")
	@ResponseStatus(HttpStatus.CREATED)
	public void multimediaAsign(@RequestBody Multimedia multimedia, @PathVariable("idDificultad")Long idDificultad) {
		Dificultad dificultad = dificultadService.findById(idDificultad);
		dificultad.agregarMultimedia(multimedia);
		dificultadService.save(dificultad);
	}
	//FIN MULTIMEDIA
	
	//ACTIVIDADES
	
	@DeleteMapping("/dificultad/delactividad")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteActividad(@RequestBody Actividad actividad) {
		dificultadService.deleteActividad(actividad);;
	
	}
	
	@PutMapping("/dificultad/actividad/{idDificultad}")
	@ResponseStatus(HttpStatus.CREATED)
	public void actividadAsign(@RequestBody Actividad actividad, @PathVariable("idDificultad")Long idDificultad) {
		Dificultad dificultadA = dificultadService.findById(idDificultad);
		dificultadA.agregarActividad(actividad);
		dificultadService.save(dificultadA);
	}
	
	//FIN ACTIVIDADES
	//REFERENTES
	
		@DeleteMapping("/dificultad/delreferentes")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteReferente(@RequestBody Referente referente) {
			dificultadService.deleteReferente(referente);
		
		}
		
		@PutMapping("/dificultad/referente/{idDificultad}")
		@ResponseStatus(HttpStatus.CREATED)
		public void referenteAsign(@RequestBody Referente referente, @PathVariable("idDificultad")Long idDificultad) {
			Dificultad dificultadA = dificultadService.findById(idDificultad);
			dificultadA.agregarReferente(referente);
			dificultadService.save(dificultadA);
		}
		
		//FIN ACTIVIDADES
}
