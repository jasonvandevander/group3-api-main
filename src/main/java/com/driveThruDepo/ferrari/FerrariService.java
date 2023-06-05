package com.driveThruDepo.ferrari;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driveThruDepo.ItemNotFoundException;

@Service
@Transactional
public class FerrariService {
	
    private final FerrariRepository ferrariRepo;
	
	@Autowired
	public FerrariService(FerrariRepository ferrariRepo) {
		this.ferrariRepo = ferrariRepo;
	}
	
	public Ferrari addFerrari(Ferrari ferrari) {
		if(ferrariRepo.count() > 9) {
			new ItemNotFoundException ("Out of capacity");
		}else 
		return ferrariRepo.save(ferrari);
		return ferrari;	
	}
	
	public List<Ferrari> findAllFerrari(){
		return ferrariRepo.findAll();
	}
	
	public Ferrari updateFerrari(Ferrari ferrari) {
		return ferrariRepo.save(ferrari);
	}
	
	public void deleteFerrari(Long id) {
		ferrariRepo.deleteFerrariById(id);
	}
	
	public Ferrari findFerrariById(Long id) {
		return ferrariRepo.findFerrariById(id).orElseThrow(()-> new ItemNotFoundException ("Car by id "+id+" was not found"));
	}

}
