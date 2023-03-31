package springboot.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.exception.ResourceNotFoundException;
import springboot.model.User;
import springboot.repository.UserRepository;
import springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void saveuser(User user) {
		this.userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "Id", id));
	}


	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "Id", id));
		
		existingUser.setFullName(user.getFullName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		
		userRepository.save(existingUser);
		return existingUser;
	}


	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("User","Id", id));
		userRepository.deleteById(id);
	}
}
