package com.api.CrudApi.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;



import com.api.CrudApi.Modelos.Usuario;
import com.api.CrudApi.Repositorio.RepositorioUsuario;

@Service
public class ServicioUsuario {

	@Autowired	
	RepositorioUsuario repositorioUsuario;
	
	public Iterable<Usuario> tenerUsuarioServicio()
	{
		return repositorioUsuario.findAll();
	}
	
	public Usuario insertarUsuariServicioServicio(Usuario usuario) {
		return repositorioUsuario.save(usuario);
	}
	
	public Optional<Usuario> tenerUsuarioIdServicio(Long id)
	{
		return repositorioUsuario.findById(id);
	}
	
	public void modificarUsuarioServicio(Usuario usuario,Long id)
	{
		Usuario usuarioSeleccionado=repositorioUsuario.findById(id).get();
		
		usuarioSeleccionado.setDniUsuario(usuario.getDniUsuario());
		usuarioSeleccionado.setNombreUsuario(usuario.getNombreUsuario());
		usuarioSeleccionado.setApellidosUsuario(usuario.getApellidosUsuario());
		usuarioSeleccionado.setTlfUsuario(usuario.getTlfUsuario());
		usuarioSeleccionado.setEmailUsuario(usuario.getEmailUsuario());
		usuarioSeleccionado.setClaveUsuario(usuario.getClaveUsuario());
		repositorioUsuario.save(usuarioSeleccionado);
	}
	
	public Boolean eliminarUsuarioServicio(Long id) {
		try {
			repositorioUsuario.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
