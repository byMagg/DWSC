package dwsc.activity4swagger.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dwsc.activity4swagger.exception.BadGatewayException;
import dwsc.activity4swagger.exception.CustomResponse;
import dwsc.activity4swagger.exception.ElementNotFoundException;
import dwsc.activity4swagger.exception.IncompleteDataException;
import dwsc.activity4swagger.exception.RepeatedExpection;
import dwsc.activity4swagger.model.User;
import dwsc.activity4swagger.model.Users;
import dwsc.activity4swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Mostrar tabla de usuarios", description = "Operación para mostrar tabla con info de usuarios")
	@GetMapping("/userstable")
	public String getUsersTab(Map<String, Users> model) {
		Users users = userService.getUsersFromDB();
		model.put("users", users);
		return "userstemplate";
	}

	@Operation(summary = "Buscar users", description = "Operación para buscar los users")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "user obtenido"),
			@ApiResponse(responseCode = "502", description = "no se ha podido obtener el usuario", content = @Content(schema = @Schema(implementation = CustomResponse.class)))

	})
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Users> getUsers() {
		Users users = userService.getUsersFromDB();
		if (users == null)
			throw new BadGatewayException(HttpStatus.BAD_GATEWAY, "no se ha podido obtener los usuarios");
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	@Operation(summary = "Añadir user", description = "Operación para añadir user dado un user")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "user creado"),
			@ApiResponse(responseCode = "400", description = "se debe introducir el usuario completo", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
			@ApiResponse(responseCode = "409", description = "username o dni repetidos", content = @Content(schema = @Schema(implementation = CustomResponse.class)))

	})
	@PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> postUser(@RequestBody User user) {
		if (user == null)
			throw new IncompleteDataException(HttpStatus.BAD_REQUEST, "Se debe introducir un usuario completo");
		int numInserted = userService.postUserToDb(user);
		if (numInserted == 0)
			throw new RepeatedExpection(HttpStatus.CONFLICT, "Username o DNI repetidos");
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@Operation(summary = "Buscar users por nombre de usuario", description = "Operación para buscar los users dado un nombre de usuario")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "user obtenido"),
			@ApiResponse(responseCode = "404", description = "user no encontrado", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
			@ApiResponse(responseCode = "502", description = "no se ha podido obtener el usuario", content = @Content(schema = @Schema(implementation = CustomResponse.class)))

	})
	@GetMapping(value = "/users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable String username) {
		User user = userService.getUserFromDb(username);
		if (user == null)
			throw new BadGatewayException(HttpStatus.BAD_GATEWAY, "No se ha podido obtener los usuarios");
		if (user.getUsername() == null)
			throw new ElementNotFoundException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Operation(summary = "Mostrar tabla de usuario", description = "Operación para mostrar tabla con info de usuario")
	@GetMapping("/userstable/{username}")
	public String getUserTab(Map<String, User> model, @PathVariable String username) {
		User user = userService.getUserFromDb(username);
		model.put("user", user);
		return "usertemplate";
	}
}