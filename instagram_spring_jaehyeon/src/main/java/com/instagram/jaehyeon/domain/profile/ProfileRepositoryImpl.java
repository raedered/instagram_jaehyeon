package com.instagram.jaehyeon.domain.profile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.jaehyeon.domain.user.User;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository{
	
	@Autowired
	private SqlSession session;
	
	private final String NAME_SPACE = "com.instagram.jaehyeon.domain.profile.ProfileRepository.";
	
	@Override
	public Account getAccountProfileByUsercode(int usercode) {
		return session.selectOne(NAME_SPACE + "getAccountProfileByUsercode", usercode);
	}
	@Override
	public int updatePassword(User user) {
		return session.selectOne(NAME_SPACE, user);
	}
	@Override
	public int updateUserDtl(Account account) {
		return session.selectOne(NAME_SPACE, account);
	}
	@Override
	public int updateUserMst(Account account) {
		return session.selectOne(NAME_SPACE, account);
	}
}
