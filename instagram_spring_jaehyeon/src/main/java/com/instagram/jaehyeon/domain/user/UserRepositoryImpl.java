package com.instagram.jaehyeon.domain.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	private SqlSession session;
	private final String NAME_SPACE = "com.instagram.jaehyeon.domain.user.userRepository.";
	
	 @Override
	public int checkUsername(String username) {
		return session.selectOne(NAME_SPACE + "chackUsername", username);
	}
	 @Override
	 public int signup(User user) {
		 return session.selectOne(NAME_SPACE + "signup", user);
	 }
	@Override
	public User getUserByUsername(String username) {
		return session.selectOne(NAME_SPACE + "getUserByUsername", username);
	}
}
