package angular_sprint.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angular_sprint.com.dao.IpersonasDAO;
import angular_sprint.com.entity.personas;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IpersonasDAO personasDAO; 
	
	@Override
	@Transactional(readOnly = true)
	public List<personas> findAll() {
		return (List<personas>) personasDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public personas insertar(personas personas) {
		return personasDAO.save(personas);
	}

	@Override
	public void Eliminar(personas p) {
		personasDAO.delete(p);
	}

	@Override
	public personas findById(Long id) {
		return personasDAO.findById(id).orElse(null);
	}

	@Override
	public personas actualizar(personas personas) {
		return personasDAO.save(personas);
	}

	@Override
	public personas findByIdentificacion(String identificacion) {
		return personasDAO.findByIdentificacion(identificacion);
	}	
	
}
