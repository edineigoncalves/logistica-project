package br.com.logistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.logistica.entities.TruckageDO;
import br.com.logistica.repository.TruckageRepository;

@RestController
@RequestMapping("/logistica/frete")
public class TruckageController {
	
	@Autowired
	TruckageRepository truckageRepository;
	
	private static final Gson gson = new Gson();
	
	/**
	 * Método usado na tela de consulta de cota
	 * @return
	 */
	@GetMapping(value="/getTruckage",produces = "application/json")
	public @ResponseBody ResponseEntity<String> calculateTruckage(String origin,String destination){
		TruckageDO truckageDO=truckageRepository.findByOriginAndDestination(origin, destination);
		Float valueTruckage=truckageDO.getDistance()*5.50f;
		return ResponseEntity.ok().body(gson.toJson("Valor de frete: R$"+valueTruckage)); 			   
	}
}
