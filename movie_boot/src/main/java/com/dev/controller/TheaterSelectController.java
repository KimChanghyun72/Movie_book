package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.TheaterDAO;
import com.dev.model.TheaterVO;

public class TheaterSelectController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TheaterVO> list = TheaterDAO.getInstance().selectAll(null);
		
		request.setAttribute("theaterList", list);
		request.setAttribute("movieList", null);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
