package com.dev.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;

public class MemberInsertController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원등록(insert).");
		//파라미터를 vo에 담기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String phone_number = request.getParameter("phone_number");
		int age = Integer.parseInt(request.getParameter("age"));
	
		//유효성 체크
		//넘어온 값을 수정하거나 유효성 체크하는 것도 여기에서 수행.
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setPhone_number(phone_number);
		member.setAge(age);
		//서비스 처리
		int r = MemberDAO.getInstance().insert(member);
		//결과 저장
		request.setAttribute("cnt", r);
		//뷰페이지로 이동
		request.getRequestDispatcher("/member/memberInsertOutput.jsp").forward(request, response);
		
	}

}
