package com.driveThruDepo.mercedes;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driveThruDepo.ItemNotFoundException;

@Service
@Transactional
public class MercedesService {
	
private final MercedesRepository mercedesRepo;
	
	@Autowired
	public MercedesService(MercedesRepository mercedesRepo) {
		this.mercedesRepo = mercedesRepo;
	}
	
	public Mercedes addMercedes(Mercedes mercedes) {
		if(mercedesRepo.count() > 29) {
			System.out.print("Out of capacity ");
		}else 
		return mercedesRepo.save(mercedes);
		return mercedes;	
	}
	
	public List<Mercedes> findAllMercedes(){
		return mercedesRepo.findAll();
	}
	
	public Mercedes updateMercedes(Mercedes mercedes) {
		return mercedesRepo.save(mercedes);
	}
	
	public void deleteMercedes(Long id) {
		mercedesRepo.deleteMercedesById(id);
	}
	
	public Mercedes findMercedesById(Long id) {
		return mercedesRepo.findMercedesById(id).orElseThrow(()-> new ItemNotFoundException ("Car by id "+id+" was not found"));
	}

}
