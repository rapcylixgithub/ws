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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import angular_sprint.com.controller.UsuariosController.ErrorInfo;
import angular_sprint.com.entity.personas;
import angular_sprint.com.services.IPersonaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/personas" })
public class PersonasController {
	@Autowired
	IPersonaService personaservice;

	@GetMapping("/listar")
	public List<personas> listar() {
		return personaservice.findAll();
	}

	@GetMapping("/buscar/{identificacion}")
	public ResponseEntity<?> Consultar(@PathVariable(value = "identificacion") String identificacion) {
		try {
			personas persona = personaservice.findByIdentificacion(identificacion);
			if (persona != null) {
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return ResponseEntity.ok(persona);
			} else {
				ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "Registro no encontrado");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/agregar")
	public ResponseEntity<?> insertar(@RequestBody personas p) {
		try {
			personas existe = personaservice.findByIdentificacion(p.getIdentificacion());
			if (existe == null) {
				personaservice.insertar(p);
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return ResponseEntity.ok(p);
			} else {
				ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(),
						"Ya se encuentra un usuario con la identificacion " + p.getIdentificacion());
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modificar")
	public personas actualizar(@RequestBody personas p) {
		return personaservice.actualizar(p);
	}

	@GetMapping("/consultar/{id}")
	public ResponseEntity<?> Consultar(@PathVariable(value = "id") Long id) {
		try {
			personas persona = personaservice.findById(id);
			if (persona != null) {
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return ResponseEntity.ok(persona);
			} else {
				ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "Registro no encontrado");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(value = "id") Long id) {
		try {
			personas persona = personaservice.findById(id);
			if (persona != null) {
				personaservice.Eliminar(persona);
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return ResponseEntity.ok(persona);
			} else {
				return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
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
