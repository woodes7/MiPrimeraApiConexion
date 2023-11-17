package com.api.CrudApi.Controlador;

public class ControladorPrestamo {
	@Autowired
	private ServicioPrestamo servicioPrestamo;
	
	@GetMapping("/prestamoSelect")
	public ArrayList<Prestamo> tenerPrestamo() {	
	return this.servicioPrestamo.tenerPrestamoServicio();
	}
	
	@GetMapping(path="/prestamoSelect/{id}")
	public Optional<Prestamo> tenerPrestamoID(@PathVariable("id") Long id) {	
	return this.servicioPrestamo.tenerPrestamoIdServicio(id);
	}
	
	@PostMapping("/prestamoInsertar")
	public void insertarPrestamo(@RequestBody Prestamo prestamo) {
		this.servicioPrestamo.insertarPrestamoServicio(prestamo);
	}
	@PutMapping(path="/prestamoActualizar/{id}")
	public void modificarPrestamo(@RequestBody Prestamo prestamo,@PathVariable("id") Long id) {
		this.servicioPrestamo.modificarPrestamoServicio(prestamo, id);
	}
	@DeleteMapping(path="/prestamoEliminar/{id}")
	public Boolean eliminarPrestamo(@PathVariable("id") Long id) {
		return this.servicioPrestamo.eliminarPrestamoServicio(id);
	}
}
