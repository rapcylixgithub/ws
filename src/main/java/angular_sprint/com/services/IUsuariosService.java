package angular_sprint.com.services;

import java.util.List;

import angular_sprint.com.entity.usuarios;

public interface IUsuariosService {
	public List<usuarios> findAll();
	public usuarios insertar(usuarios usuario);
	public usuarios login(String nombre_usuario, String contrasena);
}
