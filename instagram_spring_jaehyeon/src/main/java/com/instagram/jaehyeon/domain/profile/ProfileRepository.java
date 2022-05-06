package com.instagram.jaehyeon.domain.profile;

import com.instagram.jaehyeon.domain.user.User;

public interface ProfileRepository {
	public Account getAccountProfileByUsercode(int usercode);
	public int updateUserMst(Account account);
	public int updateUserDtl(Account account);
	public int updatePassword(User user);
}
