package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mesa")
public class Mesa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMesa;
	
	@Column(name ="estado", length = 60, nullable = false)
    private String estado;
	
	@Column(name ="zona", length = 60, nullable = false)
	private String zona;

	public Mesa() {
		super();
	}

	public Mesa(int idMesa, String estado, String zona) {
		super();
		this.idMesa = idMesa;
		this.estado = estado;
		this.zona = zona;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	
	

}
