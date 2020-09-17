package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.Movie_BookingDAO;
import com.dev.model.Movie_BookingVo;

public class MovieBookingDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ticket_num = request.getParameter("ticket_num");
		Movie_BookingVo movie_bookVo = new Movie_BookingVo();
		movie_bookVo.setTicket_num(ticket_num);
		Movie_BookingDAO.getInstance().delete(movie_bookVo);
		
		response.sendRedirect("movieBookingCk.do");
	}

}
