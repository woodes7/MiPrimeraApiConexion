package com.api.CrudApi.Controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libro")
public class ControladorLibro {
	
	@Autowired
	private ServicioLibro servicioLibro;
	
	@GetMapping("/libroSelect")
	public ArrayList<Libro> tenerLibro() {	
	return this.servicioLibro.tenerLibroServicio();
	}
	
	@GetMapping(path="/libroSelect/{id}")
	public Optional<Libro> tenerLibroID(@PathVariable("id") Long id) {
	return this.servicioLibro.tenerLibroIdServicio(id);
	}
	
	@PostMapping("/libroInsertar")
	public void insertarLibro(@RequestBody Libro libro) {
		this.servicioLibro.insertarLibroServicio(libro);
	}
	
	@PutMapping(path="/libroActualizar/{id}")
	public void modificarLibro(@RequestBody Libro libro,@PathVariable("id") Long id) {
		this.servicioLibro.modificarLibroServicio(libro, id);
	}
	
	@DeleteMapping(path="/libroEliminar/{id}")
	public Boolean eliminarLibro(@PathVariable("id") Long id) {
		return this.libroServicio.eliminarLibroServicio(id);
	}
}
