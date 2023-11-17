package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.EstadoPrestamo;
import com.api.CrudApi.Repositorio.RepositorioEstadoPrestamo;

@Service
public class ServicioEstadoPrestamo {

	@Autowired
	RepositorioEstadoPrestamo repositorioEstadoPrestamo;
	
	public ArrayList<EstadoPrestamo> tenerEstadoPrestamoServicio()
	{
		return (ArrayList<EstadoPrestamo>)repositorioEstadoPrestamo.findAll();
	}
	
	public void insertarEstadoPrestamoServicio(EstadoPrestamo estadoPrestamo)
	{
		repositorioEstadoPrestamo.save(estadoPrestamo);
	}
	
	public Optional<EstadoPrestamo> tenerEstadoPrestamoIdServicio(Long id)
	{
		return repositorioEstadoPrestamo.findById(id);
	}
	
	
	public void modificarEstadoPrestamoServicio(EstadoPrestamo estadoPrestamo,Long id)
	{
		EstadoPrestamo estadoPrestamoObtenida=repositorioEstadoPrestamo.findById(id).get();
		estadoPrestamoObtenida.setFchInicioPresta(estadoPrestamo.getFchInicioPresta());
		estadoPrestamoObtenida.setFchEntregaPresta(estadoPrestamo.getFchEntregaPresta());
		estadoPrestamoObtenida.setFchFinPresta(estadoPrestamo.getFchFinPresta());
		
		repositorioEstadoPrestamo.save(estadoPrestamoObtenida);
	}
	
	public Boolean eliminarEstadoPrestamoServicio(Long id) {
		try {
			repositorioEstadoPrestamo.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
