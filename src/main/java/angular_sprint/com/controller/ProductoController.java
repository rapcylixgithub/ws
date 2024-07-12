package angular_sprint.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import angular_sprint.com.entity.Producto;
import angular_sprint.com.entity.personas;
import angular_sprint.com.services.IProductoService;
import jakarta.persistence.Entity;
import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/productos" })
public class ProductoController {

	@Autowired
	IProductoService servicio;

	@GetMapping("/listar")
	public List<Producto> Listar() {
		return servicio.findAll();
	}
	
	
	@GetMapping("/consultar/{id}")
	public Producto Consultar(@PathVariable(value = "id") Long id) {
		return servicio.findbyId(id);
	}
	

	@PostMapping("/insertar")
	public ResponseEntity<?> Agregar(@RequestBody Producto producto) {
		try {			
			servicio.insertar(producto);
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return ResponseEntity.ok(producto);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> Actualizar(@RequestBody Producto producto) {
		try {
			servicio.actualizar(producto);
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return ResponseEntity.ok(producto);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> Eliminar(@PathVariable(value = "id") Long id) {
		try {
			Producto producto = servicio.findbyId(id);
			if (producto != null) {
				servicio.Eliminar(producto);
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return ResponseEntity.ok(producto);
			} else {
				return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	static class ErrorInfo {
		private int status;
		private String error;
		private String message;

		public ErrorInfo(int status, String message) {
			this.status = status;
			this.error = "Not Found";
			this.message = message;
		}

		// Getters y setters
		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

}
