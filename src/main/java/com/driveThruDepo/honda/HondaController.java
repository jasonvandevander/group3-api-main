package com.driveThruDepo.honda;

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
@RequestMapping("/honda")
public class HondaController {
	
private final HondaService hondaService;
	
	public HondaController(HondaService hondaService){
		this.hondaService = hondaService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Honda>> getAllHonda(){
		List<Honda> honda = hondaService.findAllHonda();
		return new ResponseEntity<> (honda, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Honda> getHondaById(@PathVariable("id") Long id){
		Honda honda = hondaService.findHondaById(id);
		return new ResponseEntity<>(honda, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Honda> addHonda(@RequestBody Honda honda){
		Honda newHonda = hondaService.addHonda(honda);
		return new ResponseEntity<>(newHonda, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Honda> updateHonda(@RequestBody Honda honda){
		Honda updateHonda = hondaService.updateHonda(honda);
		return new ResponseEntity<>(updateHonda, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHonda(@PathVariable("id") Long id){
		hondaService.deleteHonda(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
