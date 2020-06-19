package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import pe.upc.model.entity.DetallePlatoReserva;*/

@Entity
@Table(name="PlatoPersonalizado")
public class PlatoPersonalizado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlatoPersonalizado;
	
	@OneToMany(mappedBy = "platopersonalizado", cascade = CascadeType.ALL)
	private Set<DetallePlatoReserva> detallePlatoReservas;
	
	@Column(name="precioPlato", nullable=false, length=60)
	private double precioPlato;
	
	@ManyToOne
	@JoinColumn(name="idIngrediente", nullable = false)
	private Ingrediente ingrediente;
	
	@ManyToOne
	@JoinColumn(name="idPlato", nullable = false)	
	private Plato plato;

	public PlatoPersonalizado() {
		super();
	}

	public PlatoPersonalizado(int platoPersonalizado, double precioPlato, Ingrediente ingrediente, Plato plato) {
		super();
		this.idPlatoPersonalizado = platoPersonalizado;
		this.precioPlato = precioPlato;
		this.ingrediente = ingrediente;
		this.plato = plato;
	}

	public int getPlatoPersonalizado() {
		return idPlatoPersonalizado;
	}

	public void setPlatoPersonalizado(int platoPersonalizado) {
		this.idPlatoPersonalizado = platoPersonalizado;
	}

	public double getPrecioPlato() {
		return precioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		this.precioPlato = precioPlato;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

}
