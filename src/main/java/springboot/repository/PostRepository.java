package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
