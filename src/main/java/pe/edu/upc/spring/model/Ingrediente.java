package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Ingrediente")
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idIngrediente;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="nombreIngrediente", nullable = false, length=60)
	public String nombreIngrediente;

	
	@Column(name="precioIngrediente", nullable = false, length=60)
	public double precioIngrediente;

	public Ingrediente() {
		super();
	}

	public Ingrediente(int idIngrediente,String nombreIngrediente,double precioIngrediente) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombreIngrediente = nombreIngrediente;
		this.precioIngrediente = precioIngrediente;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombreIngrediente() {
		return nombreIngrediente;
	}

	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}

	public double getPrecioIngrediente() {
		return precioIngrediente;
	}

	public void setPrecioIngrediente(double precioIngrediente) {
		this.precioIngrediente = precioIngrediente;
	}
	
}
