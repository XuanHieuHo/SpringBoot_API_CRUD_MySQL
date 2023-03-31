package springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.exception.ResourceNotFoundException;
import springboot.model.Post;
import springboot.model.User;
import springboot.repository.PostRepository;
import springboot.repository.UserRepository;
import springboot.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Post savePost(Post post, long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> 
						new ResourceNotFoundException("User", "Id", userId));	
		post.setTitle(post.getTitle());
		post.setContent(post.getContent());
		post.setUser(user);
		postRepository.save(post);
		return post;
	}
	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}
	@Override
	public List<Post> getAllPostsByUser(long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> 
			new ResourceNotFoundException("User", "Id", userId));		
			return user.getPosts();
	}
	@Override
	public Post getPostById(long postId) {
		return postRepository.findById(postId).orElseThrow(() ->
				new ResourceNotFoundException("Post", "Id", postId));
	}
	@Override
	public Post updatePost(Post post, long id) {
		Post existingPost = postRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Post", "Id", id));
		
		existingPost.setTitle(post.getTitle());
		existingPost.setContent(post.getContent());
		postRepository.save(existingPost);
		return existingPost;
	}
	@Override
	public void deletePost(long id) {
		postRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Post","Id", id));
		postRepository.deleteById(id);	
	}
}
