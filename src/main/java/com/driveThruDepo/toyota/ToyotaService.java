package com.driveThruDepo.toyota;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driveThruDepo.ItemNotFoundException;

@Service
@Transactional
public class ToyotaService {
		
		private final ToyotaRepository toyotaRepo;
		
		@Autowired
		public ToyotaService(ToyotaRepository toyotaRepo) {
			this.toyotaRepo = toyotaRepo;
		}
		
		public Toyota addToyota(Toyota toyota) {
			if(toyotaRepo.count() > 49) {
				new ItemNotFoundException ("Out of capacity");
			}else 
			return toyotaRepo.save(toyota);
			return toyota;	
		}
		
		public List<Toyota> findAllToyota(){
			return toyotaRepo.findAll();
		}
		
		public Toyota updateToyota(Toyota toyota) {
			return toyotaRepo.save(toyota);
		}
		
		public void deleteToyota(Long id) {
			toyotaRepo.deleteToyotaById(id);
		}
		
		public Toyota findToyotaById(Long id) {
			return toyotaRepo.findToyotaById(id).orElseThrow(()-> new ItemNotFoundException ("Car by id "+id+" was not found"));
		}

}
