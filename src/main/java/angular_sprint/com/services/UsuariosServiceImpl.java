package angular_sprint.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angular_sprint.com.dao.IUsuariosDAO;
import angular_sprint.com.entity.usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

	@Autowired
	private IUsuariosDAO UsuariosDAO;

	@Override
	public List<usuarios> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public usuarios insertar(usuarios usuario) {
		return UsuariosDAO.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public usuarios login(String nombre_usuario, String contrasena) {
		return UsuariosDAO.findByNombre_usuarioAndContrasena(nombre_usuario, contrasena);
	}
}