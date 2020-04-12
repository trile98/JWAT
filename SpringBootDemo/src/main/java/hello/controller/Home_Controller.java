package hello.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.mysql.cj.xdevapi.JsonString;

import hello.model.ResponseData;
import hello.model.User;
import hello.service.UserService;



@Controller
public class Home_Controller{
	User recentU;
	
	@Autowired
	UserService uService;
	
	public Home_Controller() throws IOException {
		System.out.println("bean has created");
	}
	
	@RequestMapping(value = "/signup", method = { RequestMethod.POST})
    public String ProcessRegister(User u){
		System.out.println(u.getUsername());
		uService.AddNew(u);
		return "redirect:/login";
    }
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String ShowIndex() {
//		return "index";
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String ShowLogin() {
		return "login";
	}


	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String ShowRegister(Model m) {
		if(recentU!=null)
			m.addAttribute("user",recentU);
		else
			m.addAttribute("user",new User(0,"","",""));
		
		return "register";
	}
	
	@RequestMapping(value = "/signin",method = { RequestMethod.POST})
	  public String ProcessLogin(User u){
		
		List<User> users = new ArrayList<User>();
		users = uService.getUser(new User(u.getUsername(),u.getPassword()));
		
		if(!users.isEmpty())
		{
			return "redirect:/user-list";
		}
		else
			return "redirect:/login";
	  }

	
	@RequestMapping(value="/user-list", method = RequestMethod.GET)
	public ModelAndView ShowUserList()  {
		ModelAndView mView = new ModelAndView("webixtable");
		List<User> userList=new ArrayList<User>();
		userList = uService.getAllUser();
		mView.addObject("listObj", userList);
		return mView;
	}
	
	
	 @RequestMapping("/edit/{id}")
	    public String editUser(@PathVariable("id") int id, Model model) {
	        
		 	User recentUser = uService.getUserById(id);
		 	
		 	model.addAttribute("user",recentUser);
		 	
		 
	        return "edit";
	    }
	
		
}
