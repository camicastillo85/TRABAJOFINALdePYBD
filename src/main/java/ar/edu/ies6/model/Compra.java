package ar.edu.ies6.model;

import java.time.LocalDate;
//import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Compra {
	@Id
	private String idCompra;
	private String id; 
	@Column
	private Boolean estado;
	
    //@ManyToOne 
	//private Cliente cliente;
	//@ManyToOne 
	//private List<Producto> productos;
	
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate fecha; 
	@Column
	private Double total;
	
	
	public Compra() {
		
	}


	/**public Compra(String id,String idCompra, Cliente cliente, List<Producto> productos, LocalDate fecha, Double total) {
		super();
		this.id = id;
		this.idCompra=idCompra;
		this.cliente = cliente;
		this.productos = productos;
		this.fecha = fecha;
		this.total = total;
	}*/
	//templates indexCompra
	public Compra(String id,String idCompra, LocalDate fecha, Double total) {
		super();
		this.id = id;
		this.idCompra=idCompra;
		this.fecha = fecha;
		this.total = total;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}


	/**
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
	}*/


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


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
		
}
