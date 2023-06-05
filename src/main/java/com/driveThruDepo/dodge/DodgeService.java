package com.driveThruDepo.dodge;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.driveThruDepo.ItemNotFoundException;

@Service
@Transactional
public class DodgeService {
	
private final DodgeRepository dodgeRepo;
	
	@Autowired
	public DodgeService(DodgeRepository dodgeRepo) {
		this.dodgeRepo = dodgeRepo;
	}
	
	public Dodge addDodge(Dodge dodge) {
		if(dodgeRepo.count() > 39) {
			new ItemNotFoundException ("Out of capacity");
		}else 
		return dodgeRepo.save(dodge);
		return dodge;	
	}
	
	public List<Dodge> findAllDodge(){
		return dodgeRepo.findAll();
	}
	
	public Dodge updateDodge(Dodge dodge) {
		return dodgeRepo.save(dodge);
	}
	
	public void deleteDodge(Long id) {
		dodgeRepo.deleteDodgeById(id);
	}
	
	public Dodge findDodgeById(Long id) {
		return dodgeRepo.findDodgeById(id).orElseThrow(()-> new ItemNotFoundException ("Car by id "+id+" was not found"));
	}

}
