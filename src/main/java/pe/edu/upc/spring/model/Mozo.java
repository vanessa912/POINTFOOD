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
@Table(name = "Mozo")
public class Mozo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMozo;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="nombreMozo", length = 60, nullable = false)
	private String nombreMozo;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="apellidoMozo", length = 60, nullable = false)
	private String apellidoMozo;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="emailMozo", length = 60, nullable = false)
	private String emailMozo;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="telefonoMozo", length = 60, nullable = false)
	private String telefonoMozo;

	public Mozo() {
		super();
	}

	public Mozo(int idMozo, String nombreMozo, String apellidoMozo, String emailMozo, String telefonoMozo) {
		super();
		this.idMozo = idMozo;
		this.nombreMozo = nombreMozo;
		this.apellidoMozo = apellidoMozo;
		this.emailMozo = emailMozo;
		this.telefonoMozo = telefonoMozo;
	}

	public int getIdMozo() {
		return idMozo;
	}

	public void setIdMozo(int idCliente) {
		this.idMozo = idCliente;
	}

	public String getNombreMozo() {
		return nombreMozo;
	}

	public void setNombreMozo(String nombreMozo) {
		this.nombreMozo = nombreMozo;
	}

	public String getApellidoMozo() {
		return apellidoMozo;
	}

	public void setApellidoMozo(String apellidoMozo) {
		this.apellidoMozo = apellidoMozo;
	}

	public String getEmailMozo() {
		return emailMozo;
	}

	public void setEmailMozo(String emailMozo) {
		this.emailMozo = emailMozo;
	}

	public String getTelefonoMozo() {
		return telefonoMozo;
	}

	public void setTelefonoMozo(String telefonoMozo) {
		this.telefonoMozo = telefonoMozo;
	}
	
	
	
	
	

}
