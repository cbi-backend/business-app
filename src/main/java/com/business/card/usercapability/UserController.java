package com.business.card.usercapability;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.card.security.TokenProvider;
import com.business.card.usercapability.model.AuthToken;
import com.business.card.usercapability.model.LogInUser;
import com.business.card.usercapability.model.User;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
 
    // security source code
    // https://github.com/akhileshmalini/spring-security-role-jwt/blob/master/src/main/java/com/akhianand/springrolejwt/service/impl/UserServiceImpl.java

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

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

    @PostMapping("api/v0/user/auth")
    public ResponseEntity<?> generateToken(@RequestBody LogInUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @PutMapping("api/v0/user/updateById/{id}")
	@ResponseBody
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return this.userService.updateUser(id,user);
    }
    
    @PreAuthorize("hasRole('USER')")
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
