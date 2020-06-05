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
@Table(name = "Cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCliente;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="nombreCliente", length = 60, nullable = false)
	private String nombreCliente;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="apellidoCliente", length = 60, nullable = false)
	private String apellidoCliente;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="emailCliente", length = 60, nullable = false)
	private String emailCliente;
	
	@NotEmpty(message = "Completar espacio")
	@NotBlank(message = "Completar espacio")
	@Column(name ="telefonoCliente", length = 60, nullable = false)
	private String telefonoCliente;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.emailCliente = emailCliente;
		this.telefonoCliente = telefonoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	
	
	
	

}
