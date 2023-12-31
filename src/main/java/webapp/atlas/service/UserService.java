package webapp.atlas.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.atlas.model.Role;
import webapp.atlas.model.User;
import webapp.atlas.repository.RoleRepository;
import webapp.atlas.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update user
    public User updateUser(@NonNull Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());

            return userRepository.save(existingUser);
        }
        return null;
    }

    // Delete all users
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    // Delete user
    public void deleteUser(@NonNull Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersWithAdminRole() {
        Optional<Role> adminRoleOptional = roleRepository.findByName("ROLE_ADMIN");

        if (adminRoleOptional.isPresent()) {
            Role adminRole = adminRoleOptional.get();
            return userRepository.findByRolesContaining(adminRole);
        }

        return Collections.emptyList(); // No matching role found
    }

    // Other business logic related to users
}