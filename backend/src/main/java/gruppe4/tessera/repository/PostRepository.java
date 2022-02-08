package gruppe4.tessera.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import gruppe4.tessera.model.Post;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
    
}
