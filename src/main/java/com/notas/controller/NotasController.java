package com.notas.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.notas.model.Notas;
import com.notas.service.INotasService;

@Controller
public class NotasController {
	
	@Autowired
	private INotasService notasService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Notas>notas=(List<Notas>) notasService.findAll();
		model.addAttribute("notas", notas);
		return "index";
	}
	
	@GetMapping("/del/{id}")
	public String del(Model model, @PathVariable Long id) {
		notasService.deleteById(id);
		return ("redirect:/listar");
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable Long id) {
		String url = "http://localhost:8082/alumnos";
		RestTemplate restTemplate=new RestTemplate();
		Object[] listalumnos=restTemplate.getForObject(url, Object[].class);		
		model.addAttribute("listalumnos",listalumnos);
		Optional<Notas>notas=notasService.findById(id);
		model.addAttribute("notas", notas.get());
		/*
		 * Notas existe=notas.get(); System.out.println(existe.getNota1());
		 * System.out.println(existe.getNota2()); System.out.println(existe.getNota3());
		 * System.out.println(existe.getNotaFinal());
		 */
		return "form";
	}
	
	@GetMapping("/new")
	public String add(Model model, @Validated Notas m) {
		String url = "http://localhost:8082/alumnos";
		RestTemplate restTemplate=new RestTemplate();
		Object[] listalumnos=restTemplate.getForObject(url, Object[].class);	
		
		model.addAttribute("listalumnos",listalumnos);	
		
		//m.setNombreAlumno(listalumnos.toString())
		model.addAttribute("notas", new Notas());
		return "form";
	}
	
	@PostMapping("/listar")
	public String save(Model model, @Validated Notas m) {
		System.out.println(m.getIdAlumno()+m.getNombreAlumno());
		Long idal=m.getIdAlumno();
		String url = "http://localhost:8082/"+String.valueOf(idal);
		
		
		  RestTemplate restTemplate=new RestTemplate(); 
		  ResponseEntity<String> response  = restTemplate.getForEntity(url, String.class);
		  System.out.println(response.getBody());
		  String alumnoString=response.getBody();
		  int indiceInicio=alumnoString.indexOf(String.valueOf(idal));
		  int indiceFinal=alumnoString.indexOf("direccion");
		  m.setNombreAlumno(alumnoString.substring(indiceInicio+13, indiceFinal-3));
			 
		
		double promedio=(m.getNota1()+m.getNota2()+m.getNota3())/3;
		BigDecimal promedioBig = new BigDecimal(promedio);
		BigDecimal promedioRoundBig = promedioBig.setScale(2, RoundingMode.HALF_UP);
		double promedioRound = promedioRoundBig.doubleValue();
		m.setNotaFinal(promedioRound);		
		notasService.save(m);		
		model.addAttribute("notas", new Notas());
		return "redirect:/listar";
	}
	
	
}
