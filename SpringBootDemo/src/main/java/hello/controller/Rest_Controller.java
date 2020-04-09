package hello.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.model.ResponseData;
import hello.model.User;
import hello.service.UserService;

@RestController
public class Rest_Controller {
	@Autowired
	UserService uService;
	public Rest_Controller() throws IOException {
		System.out.println("Rest bean has created");
		
	}
	
	
	@RequestMapping(value = "/changeUserInfo",method = { RequestMethod.POST})
	  public @ResponseBody ResponseData ProcessChanges(@RequestBody User u){
		
		uService.UpdateUser(u);
		
		String status = "update user successfully";
		
		ResponseData responseData = new ResponseData();
		responseData.setUser(u);
		responseData.setStatus(status);
		
		return responseData;
		
	  }
	
	@RequestMapping(value = "/getList",method = { RequestMethod.GET})
	  public @ResponseBody List<User> GetList(){
		
		
		List<User> userList=new ArrayList<User>();
		userList = uService.getAllUser();
		
		return userList;
		
	  }
	
	
}
