package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.TimeTableDAO;
import com.dev.model.TimeTableVO;

public class TimetableSelectController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theater_code = request.getParameter("theater_code");
		String movie_code =  request.getParameter("movie_code");
		
		List<TimeTableVO> ttList = TimeTableDAO.getInstance().selectAll(theater_code, movie_code);
		
		request.setAttribute("ttList", ttList);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
