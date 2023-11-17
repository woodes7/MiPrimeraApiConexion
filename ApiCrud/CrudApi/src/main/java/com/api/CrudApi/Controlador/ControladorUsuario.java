package com.api.CrudApi.Controlador;
import java.util.ArrayList;
import java.util.Optional;

s


import com.api.CrudApi.Servicio.ServicioUsuario;
import com.api.CrudApi.Modelos.Usuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@GetMapping("/usuarioSelect")
	public ArrayList<Usuario> seleccionarTodosUsuario(){
		return this.servicioUsuario.todosUsuarioServicio();
	}
	
	@PostMapping("/usuarioInsertar")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return this.servicioUsuario.insertarUsuarioServicio(usuario);
	}
	
	@GetMapping(path="/usuarioSelect/{id}")
	public Optional<Usuario> selecionUnUsaurio(@PathVariable("id") Long id) {
		return this.servicioUsuario.seleccionarUsuarioIdServicio(id);
	}
	
	@PutMapping(path="/usuarioAc/{id}")
	public void actualizarUsuario(@RequestBody Usuario usuario,@PathVariable("id") Long id) {
		this.servicioUsuario.modificarUsuarioServicio(usuario, id);
	}
	
	@DeleteMapping(path="/usuarioEliminar/{id}")
	public Boolean borrarUsuario(@PathVariable("id") Long id) {
		return this.servicioUsuario.eliminarUsuarioServicio(id);
	}
}
