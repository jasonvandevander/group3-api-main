package com.driveThruDepo.ferrari;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FerrariRepository extends JpaRepository<Ferrari, Long>{
	
	void deleteFerrariById(Long id);
	Optional<Ferrari> findFerrariById(Long id);
	long count();

}
