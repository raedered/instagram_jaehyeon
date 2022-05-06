package com.instagram.jaehyeon.domain.profile;

import java.time.LocalDateTime;

import com.instagram.jaehyeon.web.dto.account.AccountResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
	private int usercode;
	private String username;
	private String name;
	private String email;
	private String phone;
	private String img_url;
	private String website;
	private String introduce;
	private int gender;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public AccountResponseDto toDto() {
		return AccountResponseDto.builder()
				.usercode(usercode)
				.username(username)
				.name(name)
				.email(email)
				.phone(phone)
				.imgUrl(img_url)
				.introduce(introduce)
				.build();
	}

}
