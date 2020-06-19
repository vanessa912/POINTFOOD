package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetallePlatoReserva;

@Repository
public interface IDetallePlatoReservaRepository extends JpaRepository<DetallePlatoReserva, Integer> {

	@Query ("from DetallePlatoReserva dP where dP.platopersonalizado.plato.nombrePlato like %:nombrePlato%")
	List<DetallePlatoReserva> buscarNombrePlato(@Param("nombrePlato")String nombrePlato);
	
	@Query("from DetallePlatoReserva dP where dP.reserva.idReserva like %:idReserva%")
	List<DetallePlatoReserva> buscarIdReserva(@Param("idReserva") int idReserva);
	
	@Query("from DetallePlatoReserva dP where dP.platopersonalizado.precioPlato like %:precioPlato%")
	List<DetallePlatoReserva> buscarprecioPlato(@Param("precioPlato") double precioPlato);
	
}
