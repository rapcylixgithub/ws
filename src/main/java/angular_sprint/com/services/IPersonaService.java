package angular_sprint.com.services;

import java.util.List;

import angular_sprint.com.entity.personas;

public interface IPersonaService {
	public List<personas> findAll();
	public personas insertar(personas personas);
	public personas actualizar(personas personas);
	public void Eliminar(personas personas);
	public personas findById(Long id);
	public personas findByIdentificacion(String identificacion);
}
