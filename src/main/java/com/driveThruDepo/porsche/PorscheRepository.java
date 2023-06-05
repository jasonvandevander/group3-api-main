package com.driveThruDepo.porsche;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorscheRepository extends JpaRepository<Porsche, Long> {
	
	void deletePorscheById(Long id);
	Optional<Porsche> findPorscheById(Long id);
	long count();

}
