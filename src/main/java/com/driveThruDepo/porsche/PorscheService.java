package com.driveThruDepo.porsche;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driveThruDepo.ItemNotFoundException;


@Service
@Transactional
public class PorscheService {
	
	private final PorscheRepository porscheRepo;
	
	@Autowired
	public PorscheService(PorscheRepository porscheRepo) {
		this.porscheRepo = porscheRepo;
	}
	
	public Porsche addPorsche(Porsche porsche) {
		if(porscheRepo.count() > 24) {
			new ItemNotFoundException ("Out of capacity");
		}else 
		return porscheRepo.save(porsche);
		return porsche;
	}
	
	public List<Porsche> findAllPorsche(){
		return porscheRepo.findAll();
	}
	
	public Porsche updatePorsche(Porsche porsche) {
		return porscheRepo.save(porsche);
	}
	
	public void deletePorsche(Long id) {
		porscheRepo.deletePorscheById(id);
	}
	
	public Porsche findPorscheById(Long id) {
		return porscheRepo.findPorscheById(id).orElseThrow(()-> new ItemNotFoundException ("Car by id "+id+" was not found"));
	}

}
