package com.instagram.jaehyeon.auth;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.jaehyeon.domain.user.User;
import com.instagram.jaehyeon.domain.user.UserRepository;

@Service
public class PrincipalServiceImpl implements PrincipalService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User loadUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
	@Override
	public boolean passwordCheck(String password, User user) {
		if(BCrypt.checkpw(password, user.getPassword())) {
			return true;
		}else {
			return false;			
		}
	}
	
}
