package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer>{

	@Query("from Reserva r where r.cliente.nombreCliente like %:nombreCliente%")
	List<Reserva>buscarNombreCliente(String nombreCliente);
	
	@Query("from Reserva r where r.mozo.nombreMozo like %:nombreMozo%")
	List<Reserva> buscarNombreMozo(@Param("nombreMozo") String nombreMozo);
	
	@Query("from Reserva r where r.mesa.zona like %:zona%")
	List<Reserva> buscarZonaMesa(@Param("zona") String zona);
	

}