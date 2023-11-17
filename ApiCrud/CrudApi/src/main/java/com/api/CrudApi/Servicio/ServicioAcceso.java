package com.api.CrudApi.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.CrudApi.Modelos.Acceso;
import com.api.CrudApi.Repositorio.RepositorioAcceso;

import java.util.Iterator;
import java.util.Optional;

@Service
public class ServicioAcceso {

	@Autowired
	RepositorioAcceso repositorioAcceso;
	
	
	public Iterable<Acceso> tenerAccesoServicio()
	{
		return repositorioAcceso.findAll();
	}
		
	public void insertarAcceso(Acceso acceso)
	{
		repositorioAcceso.save(acceso);
	}
	
	public Optional<Acceso> tenerAccesoIdServicio(Long id)
	{
		return repositorioAcceso.findById(id);
	}
	
	
	public void modificarAccesoServicio(Acceso acceso,Long id)
	{
		Acceso accesoObetnido=repositorioAcceso.findById(id).get();
		accesoObetnido.setCodigo_acceso(acceso.getCodigo_acceso());
		accesoObetnido.setDescripcion_acceso(acceso.getDescripcion_acceso());
		repositorioAcceso.save(accesoObetnido);
	}
	
	public Boolean eliminarAccesoServicio(Long id) {
		try {
			repositorioAcceso.deleteById(id);
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		return true;
		
	}
}
