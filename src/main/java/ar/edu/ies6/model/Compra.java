package ar.edu.ies6.model;

import java.time.LocalDate;
import java.util.List;//A1

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Compra {
	@Id
	private String idCompra;
	//private String id; 
	@Column
	private Boolean estado;
	@Column
	private String nombreProducto;//A1
	
    @ManyToOne //"muchos a uno"
	private Cliente cliente;//A1
	@ManyToOne//"muchos a muchos".
	private Producto producto;//A1
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate fecha; 
	@Column
	private Double total;
	@Column
	private int cantidad;
	
	public Compra() {
		
	}
	
	
	public Compra(String idCompra, Boolean estado, String nombreProducto, Cliente cliente, Producto producto,
			LocalDate fecha, Double total, int cantidad) {
		super();
		this.idCompra = idCompra;
		this.estado = estado;
		this.nombreProducto = nombreProducto;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.total = total;
		this.cantidad = cantidad;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	public Producto getProducto() {
		return producto;
	}





	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	public String getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}


	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
		
}
