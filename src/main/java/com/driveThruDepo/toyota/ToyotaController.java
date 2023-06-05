package com.driveThruDepo.toyota;

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
@RequestMapping("/toyota")
public class ToyotaController {
	
private final ToyotaService toyotaService;
	
	public ToyotaController(ToyotaService toyotaService) {
		this.toyotaService = toyotaService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Toyota>> getAllToyota(){
		List<Toyota> toyota = toyotaService.findAllToyota();
		return new ResponseEntity<> (toyota, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Toyota> getToyotaById(@PathVariable("id") Long id){
		Toyota toyota = toyotaService.findToyotaById(id);
		return new ResponseEntity<>(toyota, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Toyota> addToyota(@RequestBody Toyota toyota){
		Toyota newToyota = toyotaService.addToyota(toyota);
		return new ResponseEntity<>(newToyota, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Toyota> updateToyota(@RequestBody Toyota toyota){
		Toyota updateToyota = toyotaService.updateToyota(toyota);
		return new ResponseEntity<>(updateToyota, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteToyota(@PathVariable("id") Long id){
		toyotaService.deleteToyota(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
