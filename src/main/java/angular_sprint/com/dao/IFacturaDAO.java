package angular_sprint.com.dao;

import org.springframework.data.repository.CrudRepository;

import angular_sprint.com.entity.Factura;

public interface IFacturaDAO extends CrudRepository<Factura, Long>{

}
