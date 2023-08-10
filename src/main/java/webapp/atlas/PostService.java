package webapp.atlas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    public Post createPost(Post post){ return postRepository.save(post);}

    public List<Post> getAllPosts(){ return postRepository.findAll();}

    public Optional<Post> getPostById(Long id){ return postRepository.findById(id);}

    public Post updatePost(Long id, Post postDetails){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            Post existingPost = post.get();
            existingPost.setTitle(postDetails.getTitle());
            existingPost.setBody(postDetails.getBody());
            return postRepository.save(existingPost);
        }
        return null;
    }

    public void deleteAllPosts(){postRepository.deleteAll();}

    public void deletePost(Long id){ postRepository.deleteById(id);}

    public Post updateLikeCount(Long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            Post existingPost = post.get();
            existingPost.setLikes(existingPost.getLikes()+1);
            return postRepository.save(existingPost);
        }
        return null;
    }

    }
