package com.driveThruDepo.dodge;

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
@RequestMapping("/dodge")
public class DodgeController {
	
private final DodgeService dodgeService;
	
	public DodgeController(DodgeService dodgeService) {
		this.dodgeService = dodgeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Dodge>> getAllDodge(){
		List<Dodge> dodge = dodgeService.findAllDodge();
		return new ResponseEntity<> (dodge, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Dodge> getDodgeById(@PathVariable("id") Long id){
		Dodge dodge = dodgeService.findDodgeById(id);
		return new ResponseEntity<>(dodge, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Dodge> addDodge(@RequestBody Dodge dodge){
		Dodge newDodge = dodgeService.addDodge(dodge);
		return new ResponseEntity<>(newDodge, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Dodge> updateDodge(@RequestBody Dodge dodge){
		Dodge updateDodge = dodgeService.updateDodge(dodge);
		return new ResponseEntity<>(updateDodge, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDodge(@PathVariable("id") Long id){
		dodgeService.deleteDodge(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
