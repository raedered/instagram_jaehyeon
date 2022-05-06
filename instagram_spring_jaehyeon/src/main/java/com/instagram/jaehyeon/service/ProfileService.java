package com.instagram.jaehyeon.service;

import com.instagram.jaehyeon.web.dto.account.AccountResponseDto;
import com.instagram.jaehyeon.web.dto.account.AccountUpdateReqDto;

public interface ProfileService {
	public AccountResponseDto getAccountProfile(int usercode);
	public boolean updateAccount(AccountUpdateReqDto accountUpdateReqDto);
}
