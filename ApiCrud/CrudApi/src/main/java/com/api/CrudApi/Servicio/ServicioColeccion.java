package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.Coleccion;
import com.api.CrudApi.Repositorio.RepositorioColeccion;

@Service
public class ServicioColeccion {


	@Autowired
	RepositorioColeccion repositorioColeccion;
	
	public ArrayList<Coleccion> tenerColeccionServicio()
	{
		return (ArrayList<Coleccion>)repositorioColeccion.findAll();
	}
	
	public void insertarColeccionServicio(Coleccion coleccion)
	{
		repositorioColeccion.save(coleccion);
	}
	
	public Optional<Coleccion> tenerColeccionIdServicio(Long id)
	{
		return repositorioColeccion.findById(id);
	}
	
	
	public void modificarColeccionServicio(Coleccion coleccion,Long id)
	{
		Coleccion coleccionObetnido=repositorioColeccion.findById(id).get();
		coleccionObetnido.setIdColeccion(coleccion.getIdColeccion());
		repositorioColeccion.save(coleccionObetnido);
	}
	
	public Boolean eliminarColeccionServicio(Long id) {
		try {
			repositorioColeccion.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
