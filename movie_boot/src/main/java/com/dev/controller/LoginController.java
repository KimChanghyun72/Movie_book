package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;


public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO memberVo = new MemberVO();
		memberVo.setId(request.getParameter("id"));
		memberVo.setPassword(request.getParameter("password"));
		// 2. 서비스 처리(DB)
		MemberVO resultVo = MemberDAO.getInstance().selectOne(memberVo);

		// 3. 결과저장
		String page = "";
		if (resultVo == null) { // id 가 없음
			request.setAttribute("errormsg", "해당 ID가 없습니다.");
			page = "member/login.jsp";
		} else {
			if(memberVo.getPassword().equals(resultVo.getPassword())) { //로그인 성공 시 세션에 어트리뷰트 속성저장?
				request.getSession().setAttribute("login", resultVo);
				request.getSession().setAttribute("id", resultVo.getId());
				page = "index.jsp";
			}else { //패스워드 불일치
				request.setAttribute("errormsg", "Password가 잘 못 되었습니다.");
				page = "member/login.jsp";
			}
		}
		// 4.뷰 페이지 이동(redirect, forward) 도는 뷰 페이지 출력
		request.getRequestDispatcher(page).forward(request, response);
	}

}
