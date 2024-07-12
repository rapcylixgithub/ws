package angular_sprint.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import angular_sprint.com.dao.IFacturaDAO;
import angular_sprint.com.entity.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	IFacturaDAO ifactura;

	@Override
	public Factura insertar(Factura factura) {
		return ifactura.save(factura);
	}

	@Override
	public void Eliminar(Factura factura) {
		// TODO Auto-generated method stub

	}

}
