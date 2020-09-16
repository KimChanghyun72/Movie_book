package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberVO;
import com.dev.model.Movie_BookingDAO;

public class MovieSelect_secController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String timetable_code = request.getParameter("timetable_choice");
		int ageComm_pct=0;
		
		ArrayList<String> seatNum = Movie_BookingDAO.getInstance().selectSeatNum(timetable_code);
		MemberVO memberInfo = (MemberVO) request.getSession().getAttribute("login");
		if(memberInfo.getAge()<19) {
			ageComm_pct=6;
		}else {
			ageComm_pct=10;
		}
		
		System.out.println(seatNum);
		request.setAttribute("ageComm_pct", ageComm_pct);
		request.setAttribute("seatNum", seatNum);
		request.getRequestDispatcher("movie_boot_ticket.jsp").forward(request, response);
		
	}

}
