package ar.edu.ies6.model;

public class Producto {

	 private String id;
	 private String nombre;
	 private String descripcion;
	 private Double precio;
	 private Integer stock;
	 //private String imagenUrl;
	 
	 
	public Producto() {
		
	}
	
	public Producto(String id, String nombre, String descripcion, Double precio, Integer stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	 
	 
	 
}
