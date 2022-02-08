package gruppe4.tessera.service;
import org.springframework.stereotype.Service;
import gruppe4.tessera.model.Post;
import gruppe4.tessera.repository.PostRepository;

@Service
public class PostService {
    private PostRepository postRepository;



    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }
    
}
