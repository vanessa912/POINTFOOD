package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Ingrediente;


@Repository
public interface IIngredienteRepository extends JpaRepository <Ingrediente, Integer> {

	@Query("from Ingrediente i where i.nombreIngrediente like %:nombreIngrediente%")
	  List<Ingrediente> buscarNombre(@Param ("nombreIngrediente") String nombreIngrediente);
}
