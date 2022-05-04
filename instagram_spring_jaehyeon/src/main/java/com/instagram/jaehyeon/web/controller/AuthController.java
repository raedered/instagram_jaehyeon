package com.instagram.jaehyeon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.jaehyeon.service.AuthService;
import com.instagram.jaehyeon.web.dto.auth.SignupRequestDto;
import com.instagram.jaehyeon.web.util.auth.AuthResponseScript;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@ResponseBody
	@RequestMapping(value = "auth/signup", method = RequestMethod.POST, produces = "tect/html;charset=utf-8")
	public String sinupSubmit(SignupRequestDto signupRequestDto) {
		boolean result = authService.signup(signupRequestDto);
		AuthResponseScript script = new AuthResponseScript();
		return script.signupScript(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "auth/username/chack", method = RequestMethod.GET)
	public String usernameChack(String username) {
		return Boolean.toString(authService.cheackUsername(username));
	}
	

}
