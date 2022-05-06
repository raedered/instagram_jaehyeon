package com.instagram.jaehyeon.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.jaehyeon.auth.PrincipalService;
import com.instagram.jaehyeon.domain.user.User;
import com.instagram.jaehyeon.service.AuthService;
import com.instagram.jaehyeon.web.dto.auth.SignupRequestDto;
import com.instagram.jaehyeon.web.util.auth.AuthResponseScript;
import com.instagram.jaehyeon.web.validation.auth.AuthValidation;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;

	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String signinSubmit(String username, String password, HttpServletRequest request) throws UnsupportedEncodingException{
		AuthValidation authValidation = new AuthValidation();
		
		Map<Boolean, String> usernameIsNull = authValidation.isNull("username", username);
		Map<Boolean, String> passwordIsNull = authValidation.isNull("password", password);
		
		if(usernameIsNull != null) {
			return "redirect: /jaehyeon/auth/signin/error?msg=" + URLEncoder.encode(usernameIsNull.get(true), "UTF-8");
		}else if(passwordIsNull != null) {
			return "redirect: /jaehyeon/auth/signin/error?msg=" + URLEncoder.encode(passwordIsNull.get(true), "UTF-8");
		}
		
		User user = authService.signin(username, password);
		if(user != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
		}else {
			return "redirect: /jaehyeon/auth/signin/error?msg=" + URLEncoder.encode("로그인 정보를 확인해주세요.", "UTF-8");
		}
		
		return "redirect: /jaehyeon/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		boolean result = authService.signup(signupRequestDto);
		AuthResponseScript script = new AuthResponseScript();
		return script.signupScript(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/username/chack", method = RequestMethod.GET)
	public String usernameChack(String username) {
		return Boolean.toString(authService.cheackUsername(username));
	}
	

}
