package pe.edu.upc.spring.repository;

/*import java.util.Date;*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Plato;

@Repository
public interface IPlatoRepository extends JpaRepository <Plato, Integer> {
	@Query("from Plato p where p.nombrePlato like %:nombrePlato%")
	  List<Plato> buscarNombre(@Param ("nombrePlato") String nombrePlato);
	
	/*@Query("from Plato p where p.carta.fechaCarta like %:fechaCarta%")
	List<Plato> buscarfechaCarta(@Param("fechaCarta") Date fechaCarta);*/
}
