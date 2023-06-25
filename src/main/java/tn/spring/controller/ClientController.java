package tn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.spring.entities.Categorie;
import tn.spring.entities.Client;
import tn.spring.services.IClientService;

@RestController
public class ClientController {

	@Autowired
	IClientService clientService;

	@PostMapping("/add-Client")
	public void ajouterEtAffecterClientBoutiques(@RequestBody Client client, @RequestParam(value="idBoutiques") List<Long> idBoutiques) {
		clientService.ajouterEtAffecterClientBoutiques(client, idBoutiques);
	}

	@GetMapping("/list-client/{idBoutique}")
	public List<Client> listedeClients(@PathVariable("idBoutique") Long idBoutique){
		return clientService.listedeClients(idBoutique);
	}

	@GetMapping("/liste-clientParCategorie/{categorie}")
	public List<Client> listeDeClientsParCategorie(@PathVariable("categorie") Categorie categorie){
		return clientService.listeDeClientsParCategorie(categorie);
	}

	@GetMapping("/filter-clients/{firstLetter}")
	public List<Client> filterClientsByFirstLetter(@PathVariable("firstLetter") char firstLetter) {
		return clientService.filterClientsByFirstLetter(firstLetter);
	}
}
