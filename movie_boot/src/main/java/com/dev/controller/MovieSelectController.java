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

public class MovieSelectController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<MovieVO> movieList = MovieDAO.getInstance().selectAll(null);
		List<TheaterVO> theaterList = TheaterDAO.getInstance().selectAll(null);
		
		request.setAttribute("movieList", movieList);
		request.setAttribute("theaterList", theaterList);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
