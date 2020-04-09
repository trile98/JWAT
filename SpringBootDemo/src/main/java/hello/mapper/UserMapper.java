package hello.mapper;

import java.util.List;

import hello.model.User;

public interface UserMapper {

    public List<User> getAllUser();
    
    public List<User> getUser(User u);
    
    public void AddNew (User u);
    
    public void UpdateUser(User u);
    
    public User getUserById(int id);
    
    public void DeleteUser(int id);
}
