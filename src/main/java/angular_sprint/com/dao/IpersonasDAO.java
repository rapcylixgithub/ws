package angular_sprint.com.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import angular_sprint.com.entity.personas;

public interface IpersonasDAO extends CrudRepository<personas, Long> {

	@Query("select p from personas p where p.identificacion = ?1")
	public personas findByIdentificacion(String identificacion);
}
