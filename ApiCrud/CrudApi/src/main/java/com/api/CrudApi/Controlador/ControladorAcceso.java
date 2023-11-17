package com.api.CrudApi.Controlador;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.CrudApi.Servicio.ServicioAcceso;
import com.api.CrudApi.Modelos.Acceso;
import com.api.CrudApi.Repositorio.RepositorioAcceso;

@RestController
@RequestMapping("/acceso")
public class ControladorAcceso {

	@Autowired
	private ServicioAcceso servicioAcceso;
	
	@GetMapping("/accesoSelect")
	public Iterable<Acceso> tenerAcceso() {	
	return this.servicioAcceso.tenerAccesoServicio();
	}
	
	@GetMapping(path="/accesoSelect/{id}")
	public Optional<Acceso> tenerAccesoID(@PathVariable("id") Long id) {	
	return this.servicioAcceso.tenerAccesoIdServicio(id);
	}
	
	@PostMapping("/accesoInsertar")
	public void insertarAcceso(@RequestBody Acceso acceso) {
		this.servicioAcceso.insertarAccesoServicio(acceso);
	}
	
	@PutMapping(path="/accesoActualizar/{id}")
	public void modificarAcceso(@RequestBody Acceso acceso,@PathVariable("id") Long id) {
		this.servicioAcceso.modificarAccesoServicio(acceso, id);
	}
	
	@DeleteMapping(path="/accesoEliminar/{id}")
	public Boolean eliminarAcceso(@PathVariable("id") Long id) {
		return this.servicioAcceso.eliminarAccesoServicio(id);
	}
}
