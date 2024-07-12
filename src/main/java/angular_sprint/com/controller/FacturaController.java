package angular_sprint.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import angular_sprint.com.entity.Factura;
import angular_sprint.com.services.IFacturaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/factura" })
public class FacturaController {
	@Autowired
	IFacturaService servicio;

	@PostMapping("/insertar")
	public Factura insertar(@RequestBody Factura factura) {
		return servicio.insertar(factura);
	}

}
