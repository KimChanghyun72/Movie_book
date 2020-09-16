package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;
import com.dev.model.TheaterDAO;
import com.dev.model.TheaterVO;

public class MemberUpdateFormController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//업데이트 해 줄 내용을 DAO에서 받아 와야 함
         MemberVO id = new MemberVO();
         id.setId((String)request.getSession().getAttribute("id"));
		MemberVO member = MemberDAO.getInstance().selectOne(id);
		
		request.setAttribute("id", member.getId());
		request.setAttribute("phone_number", member.getPhone_number());
		request.setAttribute("age", member.getAge());
		
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);

	}

}
