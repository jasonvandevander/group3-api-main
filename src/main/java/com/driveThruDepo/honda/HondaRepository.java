package com.driveThruDepo.honda;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface HondaRepository extends JpaRepository<Honda, Long>{
	
	void deleteHondaById(Long id);
	Optional<Honda> findHondaById(Long id);
	
	long count();

}
