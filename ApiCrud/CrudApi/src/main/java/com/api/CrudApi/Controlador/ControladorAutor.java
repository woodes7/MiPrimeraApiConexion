package com.api.CrudApi.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.CrudApi.Modelos.Autor;
import com.api.CrudApi.Servicio.ServicioAutor;

@RestController
@RequestMapping("/autor")
public class ControladorAutor {

	@Autowired
	private ServicioAutor servicioAutor;
	
	@GetMapping("/autorSelect")
	public Iterable<Autor> tenerAutor() {	
	return this.servicioAutor.tenerAutorServicio();
	}
	
	@GetMapping(path="/autorSelect/{id}")
	public Optional<Autor> tenerAutorId(@PathVariable("id") Long id) {	
	return this.servicioAutor.tenerAutorIdServicio(id);
	}
	
	@PostMapping("/autorInsertar")
	public void insertarAutor(@RequestBody Autor autor) {
		this.servicioAutor.insertarAutorServicio(autor);
	}
	
	@PutMapping(path="/autorActualizar/{id}")
	public void modificarAutor(@RequestBody Autor autor,@PathVariable("id") Long id) {
		this.servicioAutor.modificarAutorServicio(autor, id);
	}
	
	@DeleteMapping(path="/autorEliminar/{id}")
	public Boolean eliminarAutor(@PathVariable("id") Long id) {
		return this.servicioAutor.eliminarAutorServicio(id);
	}
}
