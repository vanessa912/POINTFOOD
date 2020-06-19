package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Integer>{
	
  @Query("from Cliente c where c.nombreCliente like %:nombreCliente%")
  List<Cliente> buscarNombreCliente(@Param ("nombreCliente") String nombreCliente);
}
