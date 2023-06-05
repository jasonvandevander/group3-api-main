package com.driveThruDepo.porsche;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/porsche")
public class PorscheController {
	
	private final PorscheService porscheService;
	
	public PorscheController(PorscheService porscheService) {
		this.porscheService = porscheService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Porsche>> getAllPorsche(){
		List<Porsche> porsche = porscheService.findAllPorsche();
		return new ResponseEntity<> (porsche, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Porsche> getPorscheById(@PathVariable("id") Long id){
		Porsche porsche = porscheService.findPorscheById(id);
		return new ResponseEntity<>(porsche, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Porsche> addPorsche(@RequestBody Porsche porsche){
		Porsche newPorsche = porscheService.addPorsche(porsche);
		return new ResponseEntity<>(newPorsche, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Porsche> updatePorsche(@RequestBody Porsche porsche){
		Porsche updatePorsche = porscheService.updatePorsche(porsche);
		return new ResponseEntity<>(updatePorsche, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePorsche(@PathVariable("id") Long id){
		porscheService.deletePorsche(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
