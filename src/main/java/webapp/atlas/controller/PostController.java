package webapp.atlas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.Post;
import webapp.atlas.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails){
        return postService.updatePost(id, postDetails);
    }

    @PutMapping("/like/{id}")
    public Post updatePostLike(@PathVariable Long id){
        return postService.updateLikeCount(id);
    }

    @DeleteMapping
    public String deleteAllPosts(){
        postService.deleteAllPosts();
        return "All posts were deleted successfully";
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
