package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;
import com.dev.model.Movie_BookingDAO;
import com.dev.model.Movie_BookingVo;

public class MemberDeleteController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//파라미터 받기
		String id = (String) request.getSession().getAttribute("id");
		//유효성 체크 (생략)
		System.out.println(id);
		//Vo 에 담기
		MemberVO member = new MemberVO();
		member.setId(id);
		
		
		Movie_BookingVo booking = new Movie_BookingVo();
		booking.setId(id);
		Movie_BookingDAO.getInstance().deleteId(booking);
				
				
		MemberDAO.getInstance().delete(member);
		//결과 저장
		request.getSession().invalidate(); //로그아웃
		//뷰 페이지로 이동
		response.sendRedirect("index.jsp");
	}

}
