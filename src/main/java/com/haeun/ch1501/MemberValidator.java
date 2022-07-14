package com.haeun.ch1501;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//검증
public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Member.class.isAssignableFrom(clazz);	
		//검증할 객체의 클래스 타입정보
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Member객체 검증할 타겟
		Member member = (Member)target;		//업캐스팅
		
//		String id = member.getId();
//		
//		//공백제거하고 비어있으면
//		if(id == null || id.trim().isEmpty()) {
//			System.out.println("id is Null!");
//			//에러 메시지 전달
//			errors.rejectValue("id", "id is Null!");
//		}
		
		//공백 검사 - 한 줄로 수정이 가능
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id is Null!");
		
		String pw = member.getPw();
		
		//공백제거하고 비어있으면
		if(pw == null || pw.trim().isEmpty()) {
			
			System.out.println("password is Null!");
			//에러 메시지 전달
			errors.rejectValue("pw", "Pw is Null!");
			//멤버의 필드명이랑 같아야 함
		}
	}
}
