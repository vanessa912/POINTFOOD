package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.PlatoPersonalizado;


@Repository
public interface IPlatoPersonalizadoRepository extends JpaRepository<PlatoPersonalizado, Integer>{

	@Query("from PlatoPersonalizado pP where pP.plato.nombrePlato like %:nombrePlato%")
	List<PlatoPersonalizado> buscarNombrePlato(@Param("nombrePlato") String nombrePlato);
	
	@Query("from PlatoPersonalizado pP where pP.ingrediente.nombreIngrediente like %:nombreIngrediente%")
	List<PlatoPersonalizado> buscarIngrediente(@Param("nombreIngrediente") String nombreIngrediente);
	
	@Query("from PlatoPersonalizado pP where pP.ingrediente.precioIngrediente like %:precioIngrediente%")
	List<PlatoPersonalizado> buscarPrecioIngrediente(@Param("precioIngrediente") double precioIngrediente);
	
}
