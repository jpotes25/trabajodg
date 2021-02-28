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

import com.aprendepormi.springbootbackendapirest.models.entity.Multimedia;
import com.aprendepormi.springbootbackendapirest.models.services.IMultimediaService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class MultimediaRestController {

	@Autowired
	private IMultimediaService multimediaService;
	
	
	@GetMapping("/multimedia")
	public List<Multimedia> index(){
		return multimediaService.findAll();
	}
	
	@GetMapping("/multimedia/{id}")
	public Multimedia show(@PathVariable Long id) {
		
	return multimediaService.findById(id);
	
	}
	
	@PostMapping("/multimedia")
	@ResponseStatus(HttpStatus.CREATED)
	public Multimedia create(@RequestBody Multimedia multimedia) {
		return multimediaService.save(multimedia);
	}
	
	
	@PutMapping("/multimedia/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Multimedia update(@RequestBody Multimedia multimedia, @PathVariable Long id) {
		Multimedia multimediaActual = multimediaService.findById(id);
		multimediaActual.setNombreMultimedia(multimedia.getNombreMultimedia());
		multimediaActual.setTipoMultimedia(multimedia.getTipoMultimedia());
		multimediaActual.setEnlaceMultimedia(multimedia.getEnlaceMultimedia());
		return multimediaService.save(multimediaActual);
	}
	
	@DeleteMapping("/multimedia/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		multimediaService.delete(id);
	}
	
}
