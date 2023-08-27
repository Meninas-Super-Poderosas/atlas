package webapp.atlas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import webapp.atlas.model.Role;
import webapp.atlas.model.User;
import webapp.atlas.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    public String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }

    public boolean isCurrentUserAdmin() {
        String username = getCurrentUsername();
        if (username != null) {
            User currentUser = userRepository.findByName(username).orElse(null);
            if (currentUser != null && currentUser.getRoles() != null) {
                for (Role role : currentUser.getRoles()) {
                    if (role.getName().equals("ROLE_ADMIN")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
