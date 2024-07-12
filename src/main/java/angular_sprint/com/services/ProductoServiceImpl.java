package angular_sprint.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angular_sprint.com.dao.IProductoDAO;
import angular_sprint.com.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO iproducto; 
	
	@Transactional(readOnly = true)
	@Override
	public List<Producto> findAll() {
		return (List<Producto>) iproducto.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public Producto insertar(Producto producto) {
		return iproducto.save(producto);
	}

	@Transactional(readOnly = false)
	@Override
	public void Eliminar(Producto producto) {
		iproducto.delete(producto);
	}

	@Transactional(readOnly = false)
	@Override
	public Producto actualizar(Producto producto) {
		return iproducto.save(producto);
	}

	@Transactional(readOnly = true)
	@Override
	public Producto findbyId(Long id) {
		return iproducto.findById(id).orElse(null);
	}

	

}
