package webapp.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.atlas.model.Comment;
import webapp.atlas.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id){
        return commentRepository.findById(id);
    }

    public Comment updateComment(Long id, Comment commentDetails){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            Comment existingComment = comment.get();
            existingComment.setUser(commentDetails.getUser());
            existingComment.setPost(commentDetails.getPost());
            existingComment.setBody(commentDetails.getBody());
        }
        return null;
    }

    public void deleteALLComments(){
        commentRepository.deleteAll();
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

}
