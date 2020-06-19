package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "platos")
public class Plato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    public int idPlato;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name ="nombrePlato", length = 60, nullable = false)
    public String nombrePlato;
	
	
	@Column(name ="preciobasePlato", length = 60, nullable = false)
	public double preciobasePlato;
	
	@ManyToOne
	@JoinColumn(name="idCarta", nullable = false)
	public Carta carta;

	public Plato() {
		super();
	}

	public Plato(int idPlato, String nombrePlato, double preciobasePlato, Carta carta) {
		super();
		this.idPlato = idPlato;
		this.nombrePlato = nombrePlato;
		this.preciobasePlato = preciobasePlato;
		this.carta = carta;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	
	
	public double getPreciobasePlato() {
		return preciobasePlato;
	}

	public void setPreciobasePlato(double preciobasePlato) {
		this.preciobasePlato = preciobasePlato;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}


}
