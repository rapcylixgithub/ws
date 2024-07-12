package angular_sprint.com.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import angular_sprint.com.entity.usuarios;

public interface IUsuariosDAO extends CrudRepository<usuarios, Long>{

	@Query("select u from usuarios u where u.nombre_usuario = ?1 and u.contrasena = ?2")
	public usuarios findByNombre_usuarioAndContrasena(String nombre_usuario, String contrasena);
}
