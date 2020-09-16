package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;
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
		String reset = request.getParameter("reset");
		String path;
		System.out.println(movie_code + "," + theater_code);
		ArrayList<MovieVO> movieList = MovieDAO.getInstance().selectAll(null);
		System.out.println(movieList);

		List<TheaterVO> theaterList = TheaterDAO.getInstance().selectAll(movie_code);
		System.out.println(theaterList);
		//선택한 영화에 대한 정보 선택.
		MovieVO movieInfo = new MovieVO();
		movieInfo.setMovie_code(movie_code);
		
		movieInfo = MovieDAO.getInstance().selectOne(movieInfo);

		request.getSession().setAttribute("timetable_code", timetable_code);
		request.getSession().setAttribute("movieInfo", movieInfo);
		request.setAttribute("movieList", movieList);
		request.setAttribute("theaterList", theaterList);
		request.setAttribute("movie_choice", movie_code);
		request.setAttribute("theater_choice", theater_code);

		if (movie_code != null && theater_code != null && timetable_code != null) {
			path = "movieSelectAll_sec.do";

		} else if (movie_code != null && theater_code != null) {

			List<TimeTableVO> timetableList = TimeTableDAO.getInstance().selectAll(theater_code, movie_code);
			request.setAttribute("timetableList", timetableList);

			path = "index2.jsp";

		} else {
			path = "index2.jsp";
		}

		if (reset == "reset") {
			request.removeAttribute("timetableList");
			request.removeAttribute("theaterList");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
