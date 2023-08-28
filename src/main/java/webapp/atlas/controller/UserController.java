package webapp.atlas.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.model.Role;
import webapp.atlas.model.User;
import webapp.atlas.repository.RoleRepository;
import webapp.atlas.repository.UserRepository;
import webapp.atlas.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // Create a new user
    @PostMapping("/save")
    @Operation(summary = "Create user", description = "Accepts request/JSON. Add a brand new user to the database.")
    public String createUser(User formUser, Model model)
    {
        User user = new User();
        user.setName(formUser.getName());
        user.setEmail(formUser.getEmail());
        user.setPassword(passwordEncoder.encode(formUser.getPassword()));
        if (roleRepository.findByName("ROLE_CLIENT").isEmpty()) {
            Role role = new Role();
            role.setName("ROLE_CLIENT");
            user.getRoles().add(role);
            userRepository.save(user);
        } else {
            Role role = roleRepository.findByName("ROLE_CLIENT").get();
            user.getRoles().add(role);
            userRepository.save(user);
        }
        return "redirect:/";
    }

    // Get all users
    @GetMapping
    @Operation(summary = "Get all users.", description = "returns JSON with all users stored in the database.")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Accepts request/JSON. Updates an existing post.")
    @Parameter(name = "User id", required = true, description = "User id")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update user by ID
    @PutMapping("/{id}")
    @Operation(summary = "Update a specific Post", description = "Accepts request/JSON. Updates an existing post.")
    @Parameter(name = "User id", required = true, description = "Id of the user that will be updated")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // Delete all users
    @DeleteMapping
    @Operation(summary = "Delete all users", description = "Delete all users in the database")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "All users have been deleted successfully.";

    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a specific user", description = "Delete a specific user refereed by a specific id")
    @Parameter(name = "user id", required = true, description = "Id of the user that will be updated")
    public String deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            user.getRoles().clear();
            user.getPosts().clear();

            userRepository.deleteById(id);
        }
        return "redirect:/admin/users";
    }
}