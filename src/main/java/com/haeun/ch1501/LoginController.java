package com.haeun.ch1501;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

//스프링 컨테이너 설정 파일
@Controller
public class LoginController {
	@RequestMapping("/loginForm")	//loginForm 요청이 오면
	public String loginForm() {
		return "login";
	}
	
//	@RequestMapping("/loginOk")
//	public String loginOk(Member member, BindingResult result) {
//		String view = "loginOk";
//		
//		MemberValidator validator = new MemberValidator();
//		validator.validate(member, result);	//멤버객체, 결과
//		//에러가 있으면(true)
//		if(result.hasErrors()) {
//			view = "login";	//login 페이지로 이동
//		}	
//		
//		return view;	//loginOk 페이지 반환
//	}
	
	@RequestMapping("/loginOk")
	public String loginOk(@Valid Member member, BindingResult result) {
		String view = "loginOk";
		
//		MemberValidator validator = new MemberValidator();
//		validator.validate(member, result);	//멤버객체, 결과
		
		
		//에러가 있으면(true)
		if(result.hasErrors()) {
			view = "login";	//login 페이지로 이동
		}	
		
		return view;	//loginOk 페이지 반환
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//@Valid member가 적용됨
		binder.setValidator(new MemberValidator());
		
	}
	
}
