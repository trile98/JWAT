package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.mapper.UserMapper;
import hello.model.User;

@Service(value = "userService")
public class UserService {
	@Autowired
	UserMapper mapper;
	
	public List<User> getAllUser(){
		return mapper.getAllUser();
	}
    
    public List<User> getUser(User u){
    	return mapper.getUser(u);
    }
    
    public void AddNew (User u) {
    	mapper.AddNew(u);
    }
    
    public void UpdateUser(User u) {
    	mapper.UpdateUser(u);
    }
    
    public User getUserById(int id) {
    	return mapper.getUserById(id);
    }
    
    public void DeleteUser(int id) {
    	mapper.DeleteUser(id);
    }
}
