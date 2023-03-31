package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Post;
import springboot.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	// create new post
	@PostMapping("/{userId}")
	public ResponseEntity<Post> savePost(@RequestBody Post post
										,@PathVariable long userId) {
		return new ResponseEntity<Post>(postService.savePost(post, userId),HttpStatus.OK);
	}
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPost();
	}

	@GetMapping("/user/{userId}")
	public List<Post> get(@PathVariable long userId) {
		return postService.getAllPostsByUser(userId);
	}
	
	//get post by postId
	@GetMapping("/{postId}")
	public ResponseEntity<Post> getPostById(@PathVariable long postId) {
		return new ResponseEntity<Post>(postService.getPostById(postId),HttpStatus.OK);
	}
	
	// update post by postId
	@PutMapping("/{postId}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post
											,@PathVariable long postId) {
		return new ResponseEntity<Post>(postService.updatePost(post, postId), HttpStatus.OK);
	}
	
	// delete post by id
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePost(@PathVariable long postId) {
		postService.deletePost(postId);
		return new ResponseEntity<String>("Post deleted successfully",HttpStatus.OK);
	}
}
