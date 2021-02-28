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
import com.aprendepormi.springbootbackendapirest.models.services.IActividadService;


@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ActividadRestController {

	
	@Autowired
	private IActividadService actividadService;
	
	
	@GetMapping("/actividades")
	public List<Actividad> index(){
		return actividadService.findAll();
	}
	
	@GetMapping("/actividades/{id}")
	public Actividad show(@PathVariable Long id) {
		
	return actividadService.findById(id);
	
	}
	
	@PostMapping("/actividades")
	@ResponseStatus(HttpStatus.CREATED)
	public Actividad create(@RequestBody Actividad actividad) {
		return actividadService.save(actividad);
	}
	
	
	@PutMapping("/actividades/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Actividad update(@RequestBody Actividad actividad, @PathVariable Long id) {
		Actividad actividadActual = actividadService.findById(id);
		actividadActual.setNombreActividad(actividad.getNombreActividad());
		actividadActual.setTipoActividad(actividad.getTipoActividad());
		actividadActual.setAutorActividad(actividad.getAutorActividad());
		actividadActual.setEnlaceActividad(actividad.getEnlaceActividad());
		return actividadService.save(actividadActual);
	}
	
	@DeleteMapping("/actividades/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		actividadService.delete(id);
	}
}
