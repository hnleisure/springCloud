package cloud.simple.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.service.domain.UserService;
import cloud.simple.service.model.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Value("${mysqldb.datasource.url:Hello default}")
    private String message;

    
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		System.out.println(message);
		List<User> ls=userService.searchAll();		
		return ls;
	}
}
