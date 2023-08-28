package webapp.atlas.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import webapp.atlas.model.*;
import webapp.atlas.repository.*;
import webapp.atlas.service.AuthService;
import webapp.atlas.service.CommentService;
import webapp.atlas.service.PostService;
import webapp.atlas.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CountryRepository countryRepository;



    @GetMapping("/")
    @Operation(summary = "Home Page", description = "Returns the home view.")
    public String home(Model model) {
        return "home"; //view
    }

//    @GetMapping("/post")
//    @Operation(summary = "Post Page", description = "Returns the ListPosts view.")
//    public String post(Model model) {
//        return "post";
//    }


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
            List<Post> posts = postService.getAllPosts();
            model.addAttribute("posts", posts);
            return "list-posts";
        }
        return "redirect:/";
    }

    @GetMapping("/post")
    public String Posts(Model model){

        List<Post> posts = postService.getAllPosts();
        Country country = new Country();
        model.addAttribute("country", country);
        model.addAttribute("posts", posts);
        return "post";

    }

    @GetMapping("/post/{id}")
    public String showPost(Model model, @PathVariable Long id){
        Post post = postRepository.findById(id).get();
        List<Comment> comments = commentService.getAllComments();
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "show-post";
    }

    @PostMapping("/post/{id}/create-comment")
    public String createComment(@PathVariable Long id, @ModelAttribute Comment formComment, Model model) {
        Post post = postRepository.findById(id).get();
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setBody(formComment.getBody());
        String username = authService.getCurrentUsername();
        User user = userRepository.findByName(username).get();
        comment.setUser(user);
        commentRepository.save(comment);
        return "redirect:/post/" + id;
    }

    @PostMapping("/vote")
    public String vote(@ModelAttribute Country country, Model model){
        Optional<Country> optionalCountry = countryRepository.findByName(country.getName());
        if (optionalCountry.isPresent()) {
            Country foundCountry = optionalCountry.get();
            foundCountry.setVotes(foundCountry.getVotes() + 1);
            countryRepository.save(foundCountry);
        } else {
            Country newCountry = new Country();
            newCountry.setName(country.getName());
            newCountry.setVotes(1);
            countryRepository.save(newCountry);
        }

        return "redirect:/post";
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
            List<Role> roles = roleRepository.findAll();
            model.addAttribute("role", roles);
            return "list-role";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/users")
    public String listUsers(Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            List<User> users = userService.getUsersWithAdminRole();
            model.addAttribute("users", users);

            return "list-users";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/users/create")
    public String createUsers(Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            User user = new User();
            model.addAttribute("user", user);
            return "create-user";
        }
        return "redirect:/";
    }

    @PostMapping("/admin/users/create")
    public String userSubmit(@ModelAttribute User formUser, Model model) {
        boolean isAdmin = authService.isCurrentUserAdmin();
        if(isAdmin) {
            User staff = new User();
            staff.setName(formUser.getName());
            staff.setEmail(formUser.getEmail());
            staff.setPassword(passwordEncoder.encode(formUser.getPassword()));
            Role role = roleRepository.findByName("ROLE_ADMIN").get();
            staff.getRoles().add(role);
            userRepository.save(staff);
            return "redirect:/admin/users";
        }
        return "redirect:/";
    }

    @PostMapping("/increment-like")
    public String incrementLike(@ModelAttribute("post") Post post) {
        Post existingPost = postRepository.findById(post.getId()).orElse(null);

        if (existingPost != null) {
            existingPost.setLikes(existingPost.getLikes() + 1);
            postRepository.save(existingPost);
        }
        return "redirect:/post/" + post.getId();
    }

    @GetMapping("/sign-up")
    public String showSignupPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "sign-up";
    }

}