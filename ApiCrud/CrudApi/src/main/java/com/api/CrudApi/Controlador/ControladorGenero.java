package com.api.CrudApi.Controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class ControladorGenero {
	@Autowired
	private GeneroServicio generoServicio;
	
	@GetMapping("/generoSelect")
	public ArrayList<Genero> tenerGenero() {
	return this.generoServicio.tenerGeneroServicio();
	}
	
	@GetMapping(path="/generoSelect/{id}")
	public Optional<Genero> tenerGeneroID(@PathVariable("id") Long id) {
	return this.generoServicio.tenerGeneroIdServicio(id);
	}
	
	@PostMapping("/generoInsertar")
	public void insertarGenero(@RequestBody Genero genero) {
		this.generoServicio.insertarGeneroServicio(genero);
	}
	
	@PutMapping(path="/generoActualizar/{id}")
	public void modificarGenero(@RequestBody Genero genero,@PathVariable("id") Long id) {
		this.generoServicio.modificarGeneroServicio(genero, id);
	}
	
	@DeleteMapping(path="/generoEliminar/{id}")
	public Boolean eliminarGenero(@PathVariable("id") Long id) {
		return this.generoServicio.eliminarGeneroServicio(id);
	}
}
