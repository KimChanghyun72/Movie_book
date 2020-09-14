package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MovieDAO;
import com.dev.model.MovieVO;
import com.dev.model.TheaterDAO;
import com.dev.model.TheaterVO;
import com.dev.model.TimeTableDAO;
import com.dev.model.TimeTableVO;

public class MovieSelectController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String movie_code = request.getParameter("movie_choice");
		String theater_code = request.getParameter("theater_choice");
		String timetable_code = request.getParameter("timetable_choice");
		System.out.println(movie_code + "," + theater_code);
		List<MovieVO> movieList = MovieDAO.getInstance().selectAll(null);
		List<TheaterVO> theaterList = TheaterDAO.getInstance().selectAll(null);
		System.out.println(movieList);
		System.out.println(theaterList);
		
		request.getSession().setAttribute("timetable_code", timetable_code);
		request.getSession().setAttribute("movie_code", movie_code);
		request.setAttribute("movieList", movieList);
		request.setAttribute("theaterList", theaterList);
		request.setAttribute("movie_choice", movie_code);
		request.setAttribute("theater_choice", theater_code);
		
		if(movie_code != null && theater_code != null && timetable_code != null) {
			request.getRequestDispatcher("movieSelectAll_sec.do").forward(request, response);
			
		} else if(movie_code != null && theater_code != null) {
			
			List<TimeTableVO> timetableList = TimeTableDAO.getInstance().selectAll(theater_code, movie_code);
			request.setAttribute("timetableList", timetableList);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
			
		}else {
			
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}
		
		
	}

}
