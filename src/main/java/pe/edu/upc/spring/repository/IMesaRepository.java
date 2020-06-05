package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.spring.model.Mesa;

public interface IMesaRepository extends JpaRepository <Mesa, Integer> {
	

}
