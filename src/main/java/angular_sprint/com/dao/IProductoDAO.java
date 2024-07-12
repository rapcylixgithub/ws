package angular_sprint.com.dao;

import org.springframework.data.repository.CrudRepository;

import angular_sprint.com.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{

}
