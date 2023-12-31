package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Categorie;
import tn.spring.entities.Client;
import tn.spring.entities.Genre;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByBoutiquesId(Long idBoutique);

	List<Client> findByBoutiquesCategorie(Categorie categorie);

	List<Client> findByNomStartingWithIgnoreCase(String firstLetter);

	@Query("SELECT COUNT(c) FROM Client c WHERE c.genre = :genre")
	int getClientByGenre(@Param("genre") Genre genre);
}
