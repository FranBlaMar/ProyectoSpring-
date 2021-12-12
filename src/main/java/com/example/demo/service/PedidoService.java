package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;

@Service
public class PedidoService {
	@Autowired 
	private UsuarioService servicioUsuario;
	@Autowired 
	private ProductoService servicioProducto;
	
	private List<Pedido> pedidosList = new ArrayList<>();

	public List<Pedido> findAll() {
		return pedidosList;
	}
	
	public List<Pedido> obtenerPedidosDeUsuario(String usuario){
		List <Pedido> resultado = new ArrayList<> ();
		for(Pedido pedido: this.pedidosList) {
			if(pedido.getUsuarioPedido().getUser().equals(usuario)) {
				resultado.add(pedido);
			}
		}
		return resultado;
	}
	
	public Pedido obtenerPedidoPorReferencia(int referencia){
		Pedido resultado = null;
		for(Pedido pedido: this.pedidosList) {
			if(pedido.getReferencia() == referencia) {
				resultado = pedido;
			}
		}
		return resultado;
	}
	
	@PostConstruct
	public void init() {
		Pedido pedido1 = new Pedido(servicioUsuario.obtenerUsuario("F123"));
		pedido1.anadirProducto(this.servicioProducto.obtenerProductoPorId("111A"), 2);
		pedido1.anadirProducto(this.servicioProducto.obtenerProductoPorId("444D"), 4);
		pedido1.anadirProducto(this.servicioProducto.obtenerProductoPorId("333C"), 1);
		
		Pedido pedido2 = new Pedido(servicioUsuario.obtenerUsuario("F123"));
		pedido2.anadirProducto(this.servicioProducto.obtenerProductoPorId("222B"), 1);
		pedido2.anadirProducto(this.servicioProducto.obtenerProductoPorId("666F"), 1);
		pedido2.anadirProducto(this.servicioProducto.obtenerProductoPorId("111A"), 1);
		
		Pedido pedido3 = new Pedido(servicioUsuario.obtenerUsuario("J123"));
		pedido3.anadirProducto(this.servicioProducto.obtenerProductoPorId("555E"), 2);
		pedido3.anadirProducto(this.servicioProducto.obtenerProductoPorId("222B"), 2);
		pedido3.anadirProducto(this.servicioProducto.obtenerProductoPorId("666F"), 1);
		
		pedidosList.addAll(Arrays.asList(pedido1,pedido2,pedido3));
	}
}
