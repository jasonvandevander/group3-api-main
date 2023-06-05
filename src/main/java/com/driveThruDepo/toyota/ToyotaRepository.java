package com.driveThruDepo.toyota;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToyotaRepository extends JpaRepository<Toyota, Long>{
	
	void deleteToyotaById(Long id);
	Optional<Toyota> findToyotaById(Long id);
	long count();

}
