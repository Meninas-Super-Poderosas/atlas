package webapp.atlas.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {


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

    @GetMapping("/dashfilter")
    @Operation(summary = "Filter Page", description = "Returns the filter view.")
    public String filter(Model model) {
        return "filter";
    }

    @GetMapping("/tutorial")
    @Operation(summary = "Tutorial Page", description = "Returns the tutorial view.")
    public String tutorial(Model model) {
        return "tutorial";
    }

    @GetMapping("/login")
    @Operation(summary = "Login Page", description = "Returns the login page.")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        return "dashboard-admin";
    }
    @GetMapping("/admin/users")
    public String listUsers(Model model) {
        return "list-users";
    }

    @GetMapping("/admin/users/create")
    public String createUsers(Model model) {
        return "create-user";
    }

    @GetMapping("/admin/posts")
    public String listPosts(Model model){ return "list-posts";}

    @GetMapping("/admin/posts/create")
    public String createPosts(Model model){ return "create-post";}

    @GetMapping("/admin/filters")
    public String listFilters(Model model){ return "list-filter";}

    @GetMapping("/admin/roles")
    public String listRoles(Model model){ return "list-role";}

}