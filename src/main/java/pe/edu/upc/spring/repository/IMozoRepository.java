package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Mozo;

@Repository
public interface IMozoRepository extends JpaRepository <Mozo, Integer>{
	
  @Query("from Mozo m where m.nombreMozo like %:nombreMozo%")
  List<Mozo> buscarNombre(@Param ("nombreMozo") String nombreMozo);
}
