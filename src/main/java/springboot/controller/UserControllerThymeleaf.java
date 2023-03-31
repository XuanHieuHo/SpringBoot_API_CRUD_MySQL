package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.model.Post;
import springboot.model.User;
import springboot.service.PostService;
import springboot.service.UserService;

@Controller
@RequestMapping("/")
public class UserControllerThymeleaf {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	// list of users
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "index";
	}
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "new_user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveuser(user);
		return "redirect:/";
	}
	
	@PostMapping("/updateUser/{id}")
	public String updateUser(@PathVariable(value = "id") long id,
								@ModelAttribute("user") User user) {
		userService.updateUser(user, id);
		return "redirect:/";
		
	}
	
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateUserForm(@PathVariable(value = "id") long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") long id) {
		this.userService.deleteUser(id);
		return "redirect:/";
	}
	
	@GetMapping("/selectUserById")
	public String selectUserById(@RequestParam(value = "id")long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("listUsers",user);
		return "index";
	}
	////////////////////////////////////////////////////////////////////////////

	@GetMapping("/posts")
	public String viewPost(Model model) {
		model.addAttribute("listPosts",postService.getAllPost());
		return "post";
	}
	@GetMapping("/selectPostById")
	public String selectPostById(@RequestParam(value = "id")long id, Model model) {
		Post post = postService.getPostById(id);
		model.addAttribute("listPosts",post);
		return "post";
	}
	
	@GetMapping("/showNewPostForm/{userId}") 
	public String showNewPostForm(Model model, @PathVariable(value = "userId") long userId) {
		User user = userService.getUserById(userId);
		Post post = new Post();
		model.addAttribute("user",user);
		model.addAttribute("post",post);
		return "new_post";
	}
	@PostMapping("/savePost/{userId}")
	public String savePost(@ModelAttribute("post") Post post, @PathVariable(value = "userId") long userId) {
		postService.savePost(post, userId);
		return "redirect:/";
	}
	@GetMapping("/deletePost/{id}")
	public String deletePost(@PathVariable(value = "id") long id) {
		this.postService.deletePost(id);
		return "redirect:/";
	}
	@GetMapping("/showPostById/{id}")
	public String showPostById(@PathVariable(value = "id") long id, Model model) {
		List<Post> post = postService.getAllPostsByUser(id);
		model.addAttribute("listPosts",post);
		return "post";
	}
	@GetMapping("/showUpdatePostForm/post/{postId}")
	public String showUpdatePostForm(@PathVariable(value = "postId") long postId, Model model) {
		Post post = postService.getPostById(postId);
		model.addAttribute("post",post);
		return "update_post";
	}
	@PostMapping("/updatePost/{postId}")
	public String updatePost(@PathVariable(value = "postId") long postId, @ModelAttribute("post") Post post) {
		postService.updatePost(post, postId);
		return "redirect:/";
		
	}
}
