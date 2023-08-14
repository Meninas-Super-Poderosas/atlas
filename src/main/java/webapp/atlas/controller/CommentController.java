package webapp.atlas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.service.CommentService;
import webapp.atlas.model.Comment;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @Operation(summary = "Create comment", description = "Accepts request/JSON. Add a brand new comment and store it in the database.")
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    @GetMapping
    @Operation(summary = "Get all comments", description = "Returns a JSON with all comments listed.")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific comment", description = "Find a comment by the Id, and return it.")
    @Parameter(name = "id", required = true, description = "Country id")


    public Optional<Comment> getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @DeleteMapping
    @Operation(summary = "Delete all comments", description = "Delete every comment in the Database.")
    public String deleteAllComment(){
        commentService.deleteALLComments();
        return "All comments were deleted successfully";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete comment", description = "Find a comment by id and then delete it.")
    @Parameter(name = "id", required = true, description = "Comment ID that will be deleted.")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
