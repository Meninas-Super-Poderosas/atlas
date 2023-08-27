package webapp.atlas.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import webapp.atlas.model.Post;
import webapp.atlas.model.User;
import webapp.atlas.repository.UserRepository;
import webapp.atlas.service.AuthService;

@Controller
public class HomeController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    @Operation(summary = "Home Page", description = "Returns the home view.")
    public String home(Model model) {
        return "home"; //view
    }

    @GetMapping("/post")
    @Operation(summary = "Post Page", description = "Returns the ListPosts view.")
    public String post(Model model) {
        return "post";
    }


    @GetMapping("/login")
    @Operation(summary = "Login Page", description = "Returns the login page.")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "dashboard-admin";
        }

        return "redirect:/";
    }

    @GetMapping("/admin/posts")
    public String listPosts(Model model){

        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "list-posts";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/posts/create-post")
    public String createPosts(Model model){
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            Post post = new Post();
            model.addAttribute("post", post);
            return "create-post";
        }
        return "redirect:/";
    }


    @GetMapping("/admin/filters")
    public String listFilters(Model model){
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "list-filter";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/roles")
    public String listRoles(Model model){
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "list-role";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/users")
    public String listUsers(Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "list-users";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/users/create")
    public String createUsers(Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "create-user";
        }
        return "redirect:/";
    }

    @PostMapping("/admin/users/create")
    public String userSubmit(@ModelAttribute User user, Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            return "list-users";
        }
        return "redirect:/";
    }

    @GetMapping("/sign-up")
    public String showSignupPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "sign-up";
    }
}