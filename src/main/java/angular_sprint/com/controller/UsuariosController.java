package angular_sprint.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import angular_sprint.com.entity.personas;
import angular_sprint.com.entity.usuarios;
import angular_sprint.com.services.IPersonaService;
import angular_sprint.com.services.IUsuariosService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/usuarios" })
public class UsuariosController {
	@Autowired
	IUsuariosService usuarioservice;
	@Autowired
	IPersonaService personaservice;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody usuarios p) {
		usuarios usuario = usuarioservice.login(p.getNombre_usuario(), p.getContrasena());
		if (usuario == null) {
			ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "Usuario no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
		}
		
		//String token = getJWTToken(p.getNombre_usuario());
		
		//usuario.setToken(token);
		
		return ResponseEntity.ok(usuario);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody usuarios u) {
		try {
			personas existe = personaservice.findByIdentificacion(u.getPersona().getIdentificacion());
			if(existe == null) {
				personaservice.insertar(u.getPersona());
				usuarioservice.insertar(u);
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return ResponseEntity.ok(u);
			}	else {
				ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "Ya se encuentra un usuario con la identificacion " + u.getPersona().getIdentificacion());
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/*private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}*/

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
