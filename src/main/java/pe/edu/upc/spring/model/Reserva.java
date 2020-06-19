package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Reserva")
public class Reserva implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReserva;
	
	@OneToOne
	@JoinColumn(name="idCarta", nullable=false)
	private Carta carta;
	
	@OneToOne
	@JoinColumn(name="idMesa", nullable=false)
	private Mesa mesa;
	
	private int sillas;
	
	@OneToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="idMozo", nullable=false)
	private Mozo mozo;
	
	@Column ()
	private Date FechaReserva;
	
	@Column ()
	private Time HoraReserva;
	
	@Column ()
	private double MontoTotal;

	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
	private Set<DetallePlatoReserva> detallePlatoReservas;

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getSillas() {
		return sillas;
	}

	public void setSillas(int sillas) {
		this.sillas = sillas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Date getFechaReserva() {
		return FechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}

	public Time getHoraReserva() {
		return HoraReserva;
	}

	public void setHoraReserva(Time horaReserva) {
		HoraReserva = horaReserva;
	}

	public double getMontoTotal() {
		return MontoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		MontoTotal = montoTotal;
	}

	public Set<DetallePlatoReserva> getDetallePlatoReservas() {
		return detallePlatoReservas;
	}

	public void setDetallePlatoReservas(Set<DetallePlatoReserva> detallePlatoReservas) {
		this.detallePlatoReservas = detallePlatoReservas;
	}
	
}
