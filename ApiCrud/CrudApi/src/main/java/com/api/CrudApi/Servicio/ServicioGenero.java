package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.Genero;
import com.api.CrudApi.Repositorio.RepositorioGenero;

@Service
public class ServicioGenero {

	@Autowired
	RepositorioGenero repositorioGenero;
	
	public ArrayList<Genero> tenerGeneroServicio()
	{
		return (ArrayList<Genero>)repositorioGenero.findAll();
	}
	
	public void insertarGeneroServicio(Genero genero)
	{
		repositorioGenero.save(genero);
	}
	
	public Optional<Genero> tenerGeneroIdServicio(Long id)
	{
		return repositorioGenero.findById(id);
	}
	
	
	public void modificarGeneroServicio(Genero genero,Long id)
	{
		Genero generoObtenido=repositorioGenero.findById(id).get();
		generoObtenido.setNombreGenero(genero.getNombreGenero());
		generoObtenido.setDescripcionGenero(genero.getDescripcionGenero());
		repositorioGenero.save(generoObtenido);
	}
	
	public Boolean eliminarGeneroServicio(Long id) {
		try {
			repositorioGenero.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
