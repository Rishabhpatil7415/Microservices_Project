package com.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth.model.JwtTokenResponse;
import com.auth.model.User;
import com.auth.model.UserDTO;
import com.auth.repository.UserRepository;
import com.auth.util.JwtUtil;

public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
   

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
	
	public UserDTO saveUser(User user) {
	    User saveduser = userRepository.save(user);
		return new UserDTO(saveduser.getId(),
				saveduser.getEmail(),
				saveduser.getRoles(),
				saveduser.getUsername());
		
	}

	
	public JwtTokenResponse generateToken(String username) {
		   String token = jwtUtil.generateToken(username);
	        JwtTokenResponse jwtTokenResponse = new JwtTokenResponse();
	        jwtTokenResponse.setToken(token);
	        jwtTokenResponse.setType("Bearer");
	        jwtTokenResponse.setValidUntil(jwtUtil.extractExpiration(token).toString());
	        return jwtTokenResponse;
	}

}
