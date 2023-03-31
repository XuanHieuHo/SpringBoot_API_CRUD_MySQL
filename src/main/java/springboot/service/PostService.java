package springboot.service;

import java.util.List;

import springboot.model.Post;

public interface PostService {
	Post savePost(Post post, long userId);
	List<Post> getAllPost();
	List<Post> getAllPostsByUser(long userId);
	Post getPostById(long postId);
	Post updatePost(Post post, long id);
	void deletePost(long id);
}
