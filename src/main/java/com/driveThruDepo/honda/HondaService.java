package com.driveThruDepo.honda;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driveThruDepo.ItemNotFoundException;

@Service
@Transactional
public class HondaService {
	
private final HondaRepository hondaRepo;
	
	@Autowired
	public HondaService(HondaRepository hondaRepo) {
		this.hondaRepo = hondaRepo;
	}
	
	public Honda addHonda(Honda honda) {
		if(hondaRepo.count() > 19) {
			new ItemNotFoundException ("Out of capacity");
		}else 
		return hondaRepo.save(honda);
		return honda;	
	}
	
	public List<Honda> findAllHonda(){
		return hondaRepo.findAll();
	}
	
	public Honda updateHonda(Honda honda) {
		return hondaRepo.save(honda);
	}
	
	public void deleteHonda(Long id) {
		hondaRepo.deleteHondaById(id);
	}
	
	public Honda findHondaById(Long id) {
		return hondaRepo.findHondaById(id).orElseThrow(()-> new ItemNotFoundException ("Car by id "+id+" was not found"));
	}

}
