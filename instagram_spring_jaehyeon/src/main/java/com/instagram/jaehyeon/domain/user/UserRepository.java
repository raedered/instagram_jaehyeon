package com.instagram.jaehyeon.domain.user;

public interface UserRepository {
	public int checkUsername(String username);
	public int signup(User user);
	public User getUserByUsername(String username);
}
