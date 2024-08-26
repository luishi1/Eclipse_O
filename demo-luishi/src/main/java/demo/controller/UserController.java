package demo.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import demo.model.User;
import demo.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/")
	public String page() {
		return "Welcome";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUsers(@PathVariable long id) {
		return userRepo.findById(id);
	}

	@PostMapping("/Save")
	public String saveUsers(@RequestBody User user) {
		userRepo.save(user);
		return "Saved...";
	}

	@PutMapping("update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setNombre(user.getNombre());
		updateUser.setApellido(user.getApellido());
		updateUser.setEdad(user.getEdad());
		userRepo.save(updateUser);
		return "Update...";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Deleted user with id " + id;
	}
}
