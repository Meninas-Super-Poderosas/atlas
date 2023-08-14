package webapp.atlas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.model.Post;
import webapp.atlas.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    @Operation(summary = "Create Post", description = "Create a brand new post")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
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
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
