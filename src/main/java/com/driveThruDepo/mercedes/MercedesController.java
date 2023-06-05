package com.driveThruDepo.mercedes;

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
@RequestMapping("/mercedes")
public class MercedesController {
	
    private final MercedesService mercedesService;
	
	public MercedesController(MercedesService mercedesService) {
		this.mercedesService = mercedesService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Mercedes>> getAllMercedes(){
		List<Mercedes> mercedes = mercedesService.findAllMercedes();
		return new ResponseEntity<> (mercedes, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Mercedes> getMercedesById(@PathVariable("id") Long id){
		Mercedes mercedes = mercedesService.findMercedesById(id);
		return new ResponseEntity<>(mercedes, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Mercedes> addMercedes(@RequestBody Mercedes mercedes){
		Mercedes newMercedes = mercedesService.addMercedes(mercedes);
		return new ResponseEntity<>(newMercedes, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Mercedes> updateMercedes(@RequestBody Mercedes mercedes){
		Mercedes updateMercedes = mercedesService.updateMercedes(mercedes);
		return new ResponseEntity<>(updateMercedes, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMercedes(@PathVariable("id") Long id){
		mercedesService.deleteMercedes(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
