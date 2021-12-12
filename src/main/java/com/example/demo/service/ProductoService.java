package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;

@Service
public class ProductoService {

	private List<Producto> productosList = new ArrayList<>();

	public List<Producto> findAll() {
		return productosList;
	}
	
	public Producto obtenerProductoPorId(String id){
		Producto p = null;
		for(Producto producto: this.productosList) {
			if(producto.getId().equals(id)) {
				p = producto;
			}
		}
		return p;
	}
	
	@PostConstruct
	public void init() {
		this.productosList.addAll( Arrays.asList (new Producto("111A","Camiseta","src/main/resource/static/camiseta.jpg", 6.99),new Producto("222B","Sudadera","src/main/resource/static/sudadera.jpg", 26.50),new Producto("333C","Botines","src/main/resource/static/botines.jpg", 36.25),new Producto("444D","Gorro","src/main/resource/static/gorro.jpg", 5.99), new Producto("555E","Pendiente","src/main/resource/static/pendiente.jpg", 2.50),new Producto("666F","Pantalon","src/main/resource/static/pantalon.jpg", 19.99) ));
	}
	
}
