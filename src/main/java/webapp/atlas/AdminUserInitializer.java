package webapp.atlas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import webapp.atlas.model.Role;
import webapp.atlas.model.User;
import webapp.atlas.repository.UserRepository;

@Component
public class AdminUserInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createAdminUser();
    }

    private void createAdminUser() {
        if (userRepository.findByName("adminatlaswebapp@gmail.com").isEmpty()) {
            User adminUser = new User();
            adminUser.setName("Admin");
            adminUser.setEmail("adminatlaswebapp@gmail.com");
            adminUser.setPassword(passwordEncoder.encode("admin"));

            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");

            adminUser.getRoles().add(adminRole);

            userRepository.save(adminUser);
        }
    }
}
