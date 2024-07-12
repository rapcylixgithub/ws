package angular_sprint.com.services;

import java.util.List;

import angular_sprint.com.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findbyId(Long id);
	public Producto insertar(Producto producto);
	public void Eliminar(Producto producto);
	public Producto actualizar(Producto producto);
	
}
