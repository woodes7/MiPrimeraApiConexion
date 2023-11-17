package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.CrudApi.Modelos.Autor;
import com.api.CrudApi.Repositorio.RepositorioAutro;

@Service
public class ServicioAutor {
	@Autowired
	RepositorioAutro repositorioAutor;
	
	public ArrayList<Autor> tenerAccesoServicio()
	{
		return (ArrayList<Autor>)repositorioAutor.findAll();
	}
	
	public void insertarAutorServicio(Autor autor)
	{
		repositorioAutor.save(autor);
	}
	
	public Optional<Autor> tenerAutorIdServicio(Long id)
	{
		return repositorioAutor.findById(id);
	}
	
	
	public void modificarAutorServicio(Autor autor,Long id)
	{
		Autor autorObetnido=repositorioAutor.findById(id).get();
		autorObetnido.setNombreAutor(autor.getNombreAutor());
		autorObetnido.setApellidosAutor(autor.getApellidosAutor());
		repositorioAutor.save(autorObetnido);
	}
	
	public Boolean eliminarAutorServicio(Long id) {
		try {
			repositorioAutor.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
