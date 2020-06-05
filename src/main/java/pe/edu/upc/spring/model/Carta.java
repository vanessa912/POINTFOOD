package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "carta")
public class Carta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCarta;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaCarta")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCarta;

	public Carta() {
		super();
	}

	public Carta(int idCarta, Date fechaCarta) {
		super();
		this.idCarta = idCarta;
		this.fechaCarta = fechaCarta;
	}

	public int getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}

	public Date getfechaCarta() {
		return fechaCarta;
	}


	public void setfechaCarta(Date fechaCarta) {
		this.fechaCarta = fechaCarta;
	}
	

}
