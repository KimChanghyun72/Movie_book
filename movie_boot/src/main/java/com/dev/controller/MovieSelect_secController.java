package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.Movie_BookingDAO;

public class MovieSelect_secController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String timetable_code = request.getParameter("timetable_choice");
				
		ArrayList<String> seatNum = Movie_BookingDAO.getInstance().selectSeatNum(timetable_code);
		System.out.println(seatNum);
		request.setAttribute("seatNum", seatNum);
		request.getRequestDispatcher("movie_boot_ticket.jsp").forward(request, response);
	}

}
