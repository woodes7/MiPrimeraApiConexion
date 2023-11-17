package com.api.CrudApi.Controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editorial")
public class ControladorEditorial {
	
	@Autowired
	private EditorialServicio editorialServicio;
	
	@GetMapping("/editorialSelect")
	public ArrayList<Editorial> tenerEditorial() {
	return this.editorialServicio.tenerEditorialServicio();
	}
	
	@GetMapping(path="/editorialSelect/{id}")
	public Optional<Editorial> tenerEditorialID(@PathVariable("id") Long id) {	
	return this.editorialServicio.tenerEditorialIdServicio(id);
	}
	
	@PostMapping("/editorialInsertar")
	public void insertarEditorial(@RequestBody Editorial editorial) {
		this.editorialServicio.insertarEditorialServicio(editorial);
	}
	
	@PutMapping(path="/editorialActualizar/{id}")
	public void modificarEditorial(@RequestBody Editorial editorial,@PathVariable("id") Long id) {
		this.editorialServicio.modificarEditorialServicio(editorial, id);
	}
	
	@DeleteMapping(path="/editorialEliminar/{id}")
	public Boolean eliminarEditorial(@PathVariable("id") Long id) {
		return this.editorialServicio.eliminarEditorialServicio(id);
	}
}
