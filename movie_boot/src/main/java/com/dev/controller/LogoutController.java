package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;


public class LogoutController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 4.뷰 페이지 이동(redirect, forward) 도는 뷰 페이지 출력
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}

}
