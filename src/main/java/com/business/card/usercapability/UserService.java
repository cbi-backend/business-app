package com.business.card.usercapability;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.business.card.usercapability.model.Role;
import com.business.card.usercapability.model.User;

@Service(value = "userService")
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        System.out.println("fetched user : " + user);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getSocial().getEmail(), user.getPassword(), getAuthority(user));
    }
    
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public User saveUser(User user) {
        prepareUserdataForCreation(user);
        return this.userRepository.save(user);
    }

    private void prepareUserdataForCreation(User user) {
        user.setId(null);
        user.setRoles(Collections.singleton(new Role(0,"USER","role for user")));
        user.setPassword(encodedPassword(user));
        user.setStatus("CREATED");
        user.setCreatedAt(new Date(System.currentTimeMillis()));        
        user.setUpdatedAt(new Date(System.currentTimeMillis()));
        user.setUserId("BUSINESS_CARD_APP_USER_" + System.currentTimeMillis());
    }

    private String encodedPassword(User user) {
        return new BCryptPasswordEncoder().encode(user.getPassword());
    }

    public User updateUser(String id, User user) {
        if (this.userRepository.existsById(id)) {
            Optional<User> userById = this.userRepository.findById(id);
            if (userById != null && userById.get() != null) {
                User tobeupdated = prepareUserdataForUpdation(user, userById.get());
              return this.userRepository.save(tobeupdated);  
            }
        }
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
    }

    private User prepareUserdataForUpdation(User user, User oldUser) {
        if (user.getName() != null && oldUser.getName() != null) {
            oldUser.setName(user.getName());
            if (user.getName().getFirstName() != null) {
                oldUser.getName().setFirstName(user.getName().getFirstName());
            }
            if (user.getName().getLastName() != null) {
                oldUser.getName().setLastName(user.getName().getLastName());
            }
        }
        if (user.getPhone() != null && oldUser.getPhone() != null) {
            if (user.getPhone().getCountryCode() != null) {
                oldUser.getPhone().setCountryCode(user.getPhone().getCountryCode());
            }
            if (user.getPhone().getNumber() != null) {
                oldUser.getPhone().setNumber(user.getPhone().getNumber());
            }
        }
        if (user.getAddress() != null && oldUser.getAddress() != null) {
            if (user.getAddress().getAddressLine1() != null) {
                oldUser.getAddress().setAddressLine1(user.getAddress().getAddressLine1());
            }
            if (user.getAddress().getAddressLine2() != null) {
                oldUser.getAddress().setAddressLine2(user.getAddress().getAddressLine2());
            }
            if (user.getAddress().getCity() != null) {
                oldUser.getAddress().setCity(user.getAddress().getCity());
            }
            if (user.getAddress().getState() != null) {
                oldUser.getAddress().setState(user.getAddress().getState());
            }
            if (user.getAddress().getCountry() != null) {
                oldUser.getAddress().setCountry(user.getAddress().getCountry());
            }
            if (user.getAddress().getPostalCode() != null) {
                oldUser.getAddress().setPostalCode(user.getAddress().getPostalCode());
            }
        }
        if (user.getSocial() != null && oldUser.getSocial() != null) {
            if (user.getSocial().getEmail() != null) {
                oldUser.getSocial().setEmail(user.getSocial().getEmail());
            }
        }
        if (user.getDateOfBirth() != null) {
            oldUser.setDateOfBirth(user.getDateOfBirth());
        }
        if (user.getGender() != null) {
            oldUser.setGender(user.getGender());
        }
        if (user.getImage() != null) {
            oldUser.setImage(user.getImage());
        }
        oldUser.setUpdatedAt(new Date(System.currentTimeMillis()));
        return oldUser;
    }

    public User getUserById(String id) {
        if (this.userRepository.existsById(id)) {
            Optional<User> user = this.userRepository.findById(id);
            if (user != null && user.get() != null && ! user.get().getStatus().equals("DELETED")) {
              return user.get();  
            }
        }
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User validateUser(User user){
        User validUser = this.userRepository.validateUser(user.getSocial().getEmail(),encodedPassword(user));
        if (validUser != null && 
            validUser.getSocial().getEmail().equals(user.getSocial().getEmail())) {
            return user;
        }
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
    }

    public User updateUserPassword(User user) {
        Integer updatedResponse = this.userRepository.updatePassword(user.getSocial().getEmail(),encodedPassword(user));
        System.out.println("updatedResponse: " + updatedResponse);
        if (updatedResponse != 0) {
            return user;
        }
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));  
    }

    public User deleteUser(String id) {
        if (this.userRepository.existsById(id)) {
            Optional<User> user = this.userRepository.findById(id);
            if (user != null && user.get() != null && ! user.get().getStatus().equals("DELETED")) {
              Integer updatedResponse = this.userRepository.updateStatusAsDeleted(id,"DELETED"); 
              System.out.println("updatedResponse: " + updatedResponse);
                if (updatedResponse != 0) {
                    return user.get();
                } 
            
            }
        }
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
    }
}
