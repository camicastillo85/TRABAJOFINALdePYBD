package ar.edu.ies6.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Cliente {

	//private String id;
	@Id
	private String dniCliente;
	@Column
    private String nombre;
	@Column
    private String email;
	@Column
    private String telefono;
	@Column
    private String direccion;
    
    
    
	public Cliente() {
		
	}
	
	
	
	public Cliente(String dniCliente, String nombre, String email, String telefono, String direccion) {
		super();
		this.dniCliente = dniCliente;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}



	public String getDniCliente() {
		return dniCliente;
	}



	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void addAttribute(String string, Iterable<Cliente> all) {
		// TODO Auto-generated method stub
		
	}
    
	
	
    
}	