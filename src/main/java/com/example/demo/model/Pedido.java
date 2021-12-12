package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Pedido {
	private static int creacionReferencia = 0000;
	private int referencia;
	private Usuario usuarioPedido;
	private HashMap <Producto,Integer> listaProductos;
	private LocalDate fechaPedido;
	
	public Pedido(Usuario usuarioPedido) {
		super();
		this.referencia = creacionReferencia+1;
		creacionReferencia ++;
		this.usuarioPedido = usuarioPedido;
		this.fechaPedido = LocalDate.now();
		this.listaProductos = new HashMap<>();
	}

	public int getReferencia() {
		return referencia;
	}

	public Usuario getUsuarioPedido() {
		return usuarioPedido;
	}

	public void setUsuarioPedido(Usuario usuarioPedido) {
		this.usuarioPedido = usuarioPedido;
	}

	public HashMap<Producto,Integer> getListaProductos() {
		return listaProductos;
	}

	public void anadirProducto(Producto p, int cantidad) {
		this.listaProductos.put(p, cantidad);
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(referencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return referencia == other.referencia;
	}

	@Override
	public String toString() {
		return "Pedido con referencia " + referencia + ", usuarioPedido: " + usuarioPedido + ", listaProductos: "
				+ listaProductos + ", fechaPedido: " + fechaPedido + "\n";
	}
	
}
