package com.api.CrudApi.Controlador;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.api.CrudApi.Modelos.EstadoPrestamo;
import com.api.CrudApi.Repositorio.RepositorioEstadoPrestamo;

public class ControladorEstadoPrestamo {
	@Autowired
	private ServicioEstadoPrestamo servicioEstadoPrestamo;
	
	@GetMapping("/estadoPrestamoSelect")
	public ArrayList<EstadoPrestamo> tenerEstadoPrestamo() {
	return this.servicioEstadoPrestamo.tenerEstadoPrestamoServicio();
	}
	
	@GetMapping(path="/estadoPrestamoSelect/{id}")
	public Optional<EstadoPrestamo> tenerEstadoPrestamoId(@PathVariable("id") Long id) {	
	return this.servicioEstadoPrestamo.tenerEstadoPrestamoIdServicio(id);
	}
	
	@PostMapping("/estadoPrestamoInsertar")
	public void insertarEstadoPrestamo(@RequestBody EstadoPrestamo estadoPrestamo) {
		this.servicioEstadoPrestamo.insertarEstadoPrestamoServicio(estadoPrestamo);
	}
	
	@PutMapping(path="/estadoPrestamoActualizar/{id}")
	public void modificarEstadoPrestamo(@RequestBody EstadoPrestamo estadoPrestamo,@PathVariable("id") Long id) {
		this.servicioEstadoPrestamo.modificarEstadoPrestamoServicio(estadoPrestamo, id);
	}
	
	@DeleteMapping(path="/estadoPrestamoEliminar/{id}")
	public Boolean eliminarEstadoPrestamo(@PathVariable("id") Long id) {
		return this.servicioEstadoPrestamo.eliminarEstadoPrestamoServicio(id);
	}
}
