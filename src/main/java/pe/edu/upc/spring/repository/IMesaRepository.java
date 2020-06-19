package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Mesa;

@Repository
public interface IMesaRepository extends JpaRepository <Mesa, Integer> {
	

}
