package br.com.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logistica.entities.TruckageDO;

public interface TruckageRepository extends JpaRepository<TruckageDO, Long>{
	
	public TruckageDO findByOriginAndDestination(String origin,String destination);
	
	
}
