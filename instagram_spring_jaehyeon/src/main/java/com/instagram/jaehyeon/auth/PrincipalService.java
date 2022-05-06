package com.instagram.jaehyeon.auth;

import com.instagram.jaehyeon.domain.user.User;

public interface PrincipalService {
	public User loadUserByUsername(String username);
	public boolean passwordCheck(String password, User user);
}
