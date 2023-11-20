package com.business.card.usercapability;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.card.usercapability.model.User;

@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
	}

    @PostMapping("api/v0/user/register")
	@ResponseBody
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }
    @PutMapping("api/v0/user/updateById/{id}")
	@ResponseBody
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return this.userService.updateUser(id,user);
    }
    @GetMapping("api/v0/user/getById/{id}")
	@ResponseBody
    public User getUserById(@PathVariable("id") String id) {
        return this.userService.getUserById(id);
    }
    @GetMapping("api/v0/user/getByEmail/{email}")
	@ResponseBody
    public User getUserByEmail(@PathVariable("email") String email) {
        return this.userService.getUserByEmail(email);
    }
    @PutMapping("api/v0/user/changesPassword")
	@ResponseBody
    public User updatePassword(@RequestBody User user) {
        return this.userService.updateUserPassword(user);
    }
    @PutMapping("api/v0/user/delete/{id}")
	@ResponseBody
    public User deleteUser(@PathVariable("id") String id) {
        return this.userService.deleteUser(id);
    }
}
