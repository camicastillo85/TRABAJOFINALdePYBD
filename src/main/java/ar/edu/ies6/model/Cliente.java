package ar.edu.ies6.model;

import org.springframework.stereotype.Component;

@Component

public class Cliente {

	private String id;
	private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    
    
    //constructor
    public Cliente() {
    	
    }
	
	public Cliente(String id, String nombre, String apellido, String email, String telefono, String direccion, String dni) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
}


		