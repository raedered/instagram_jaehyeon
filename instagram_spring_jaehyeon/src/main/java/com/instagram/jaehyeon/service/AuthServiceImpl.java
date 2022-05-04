package com.instagram.jaehyeon.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.instagram.jaehyeon.domain.user.UserRepository;
import com.instagram.jaehyeon.web.dto.auth.SignupRequestDto;

public class AuthServiceImpl implements AuthService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean cheackUsername(String username) {
		return userRepository.checkUsername(username) != 0 ? true : false;
	}
	
	@Override
	public boolean signup(SignupRequestDto signupRequestDto) {
		int result = userRepository.signup(signupRequestDto.toEntity());
		return result != 0;
	}
}
