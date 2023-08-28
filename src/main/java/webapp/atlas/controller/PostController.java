package webapp.atlas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.model.Post;
import webapp.atlas.model.User;
import webapp.atlas.repository.PostRepository;
import webapp.atlas.repository.UserRepository;
import webapp.atlas.service.AuthService;
import webapp.atlas.service.PostService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    @Operation(summary = "Create Post", description = "Create a brand new post")
    public String createPost(Post formPost, Model model){
        Post post = new Post();
        post.setTitle(formPost.getTitle());
        post.setBody(formPost.getBody());
        post.setDescription(formPost.getDescription());
        post.setCountryName(formPost.getCountryName());
        post.setFlagUrl(formPost.getFlagUrl());
        post.setLikes(0);
        String username = authService.getCurrentUsername();
        User user = userRepository.findByName(username).get();
        post.setUser(user);
        postRepository.save(post);

        return "redirect:/admin/posts";
    }

    @GetMapping
    @Operation(summary = "Get All Posts", description = "Returns every posts in DataBase")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific post", description = "Gets a post by the id")
    @Parameter(name = "post id", required = true, description = "Post id")
    public Optional<Post> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a specific Post", description = "Accepts request/JSON. Updates an existing post.")
    @Parameter(name = "post id", required = true, description = "Id of the post that will be updated")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails){
        return postService.updatePost(id, postDetails);
    }

    @PutMapping("/like/{id}")
    @Operation(summary = "Add Likes", description = "Add one (1) like to the post.")
    @Parameter(name = "post id", required = true, description = "Id of the country that will be updated")
    public Post updatePostLike(@PathVariable Long id){
        return postService.updateLikeCount(id);
    }

    @DeleteMapping
    @Operation(summary = "Delete all Country", description = "Delete all posts in database")
    public String deleteAllPosts(){
        postService.deleteAllPosts();
        return "All posts were deleted successfully";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Post", description = "Delete a specific post refereed by a specific id")
    @Parameter(name = "post id", required = true, description = "Id of the post that will be deleted")
    public String deletePost(@PathVariable Long id){
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(value -> postRepository.deleteById(value.getId()));
        return "redirect:/admin/posts";
    }

}
