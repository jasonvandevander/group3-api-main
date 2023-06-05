package com.driveThruDepo.mercedes;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercedesRepository extends JpaRepository<Mercedes, Long>{
	
	void deleteMercedesById(Long id);
	Optional<Mercedes> findMercedesById(Long id);
	
	long count();

}
