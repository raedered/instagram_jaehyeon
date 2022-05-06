package com.instagram.jaehyeon.service;

import com.instagram.jaehyeon.domain.user.User;
import com.instagram.jaehyeon.web.dto.auth.SignupRequestDto;

public interface AuthService {
	public boolean cheackUsername(String username);
	public boolean signup(SignupRequestDto signupRequestDto);
	public User signin(String username, String password);
}
