package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MovieBookListDAO;
import com.dev.model.MovieBookListVO;
import com.dev.model.MovieDAO;
import com.dev.model.Movie_BookingDAO;
import com.dev.model.Movie_BookingVo;

public class MovieBookingCkController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = (String)request.getSession().getAttribute("id");
		ArrayList<MovieBookListVO> movieBookList = MovieBookListDAO.getInstance().selectAll(id);
		request.setAttribute("movieBookList", movieBookList);
		
		request.getRequestDispatcher("movie_booking_ck.jsp").forward(request, response);
		
	}

}
