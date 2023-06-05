package com.driveThruDepo.ferrari;

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
@RequestMapping("/ferrari")
public class FerrariController {
	
    private final FerrariService ferrariService;
	
	public FerrariController(FerrariService ferrariService) {
		this.ferrariService = ferrariService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Ferrari>> getAllFerrari(){
		List<Ferrari> ferrari = ferrariService.findAllFerrari();
		return new ResponseEntity<> (ferrari, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Ferrari> getFerrariById(@PathVariable("id") Long id){
		Ferrari ferrari = ferrariService.findFerrariById(id);
		return new ResponseEntity<>(ferrari, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Ferrari> addFerrari(@RequestBody Ferrari ferrari){
		Ferrari newFerrari = ferrariService.addFerrari(ferrari);
		return new ResponseEntity<>(newFerrari, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Ferrari> updateFerrari(@RequestBody Ferrari ferrari){
		Ferrari updateFerrari = ferrariService.updateFerrari(ferrari);
		return new ResponseEntity<>(updateFerrari, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFerrari(@PathVariable("id") Long id){
		ferrariService.deleteFerrari(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
