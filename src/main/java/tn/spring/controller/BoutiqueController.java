package tn.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.spring.entities.Boutique;
import tn.spring.services.IBoutiqueService;

@RestController
public class BoutiqueController {
	Logger logger = LoggerFactory.getLogger(BoutiqueController.class);

	@Autowired
	IBoutiqueService boutiqueService;
	
	@PostMapping("/add-listeBoutique/{idCentre}")
	@ResponseBody
	void ajouterEtaffecterListeboutique(@RequestBody List<Boutique> lb,@PathVariable("idCentre") Long idCentre) {
		boutiqueService.ajouterEtaffecterListeboutique(lb, idCentre);
	}
	
	@GetMapping("/liste-boutique/{idCentre}")
	@ResponseBody
	List<Boutique> listedeBoutiques(@PathVariable("idCentre") Long idCentre){
		return boutiqueService.listedeBoutiques(idCentre);
	}

}
