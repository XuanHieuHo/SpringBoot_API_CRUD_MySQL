package springboot.service;

import java.util.List;

import springboot.model.User;

public interface UserService {
	User saveUser(User user);
	void saveuser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
}
