package ar.edu.ies6.model;

import java.time.LocalDate;
import java.util.List;

public class Compra {

	private String id; 
	private Cliente cliente;
	private List<Producto> productos;
	private LocalDate fecha; 
	private Double total;
	
	
	public Compra() {
		
	}


	public Compra(String id, Cliente cliente, List<Producto> productos, LocalDate fecha, Double total) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.productos = productos;
		this.fecha = fecha;
		this.total = total;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
}
