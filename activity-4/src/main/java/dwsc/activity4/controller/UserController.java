package dwsc.activity4.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import dwsc.activity4.model.User;
import dwsc.activity4.model.Users;
import dwsc.activity4.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/userstable")
	public String getUsersTab(Map<String, Users> model) {
		Users users = userService.getUsersFromDB();
		model.put("users", users);
		return "userstemplate";
	}

	@RequestMapping("/users")
	public @ResponseBody ResponseEntity<Users> getUsers() {
		Users users = userService.getUsersFromDB();
		if(users == null) throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "ERROR: no se ha podido obtener los usuarios");
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public @ResponseBody ResponseEntity<User> postUser(@RequestBody User user) {
		if(user == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR: Se debe introducir un usuario completo");
		int numInserted = userService.postUserToDb(user);
		if(numInserted == 0) throw new ResponseStatusException(HttpStatus.CONFLICT, "ERROR: Username o DNI repetidos");
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping("/users/{username}")
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable String username) {
		User user = userService.getUserFromDb(username);
		if(user == null) throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "ERROR: no se ha podido obtener los usuarios");
		if(user.getUsername() == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR: Usuario no encontrado"); 
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping("/userstable/{username}")
	public String getUserTab(Map<String, User> model, @PathVariable String username) {
		User user = userService.getUserFromDb(username);
		model.put("user", user);
		return "usertemplate";
	}
}