package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MovieDAO;
import com.dev.model.MovieVO;

public class MovieSelect_preController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("id");
		String page = "";
		
		if(id==null) {
			request.setAttribute("errormsg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("errorcode", "1");
			page = "member/login.jsp";
		}else {
			ArrayList<MovieVO> movieList = MovieDAO.getInstance().selectAll(null);
			request.setAttribute("movieList", movieList);
			page = "index2.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
