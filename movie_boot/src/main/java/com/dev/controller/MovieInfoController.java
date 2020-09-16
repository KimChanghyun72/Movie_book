package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberVO;
import com.dev.model.MovieDAO;
import com.dev.model.MovieVO;
import com.dev.model.Movie_BookingDAO;
import com.dev.model.Movie_BookingVo;

public class MovieInfoController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie_BookingVo movie_bookingVo = new Movie_BookingVo();
		MemberVO memberInfo = (MemberVO) request.getSession().getAttribute("login");
		MovieVO movieInfo = new MovieVO();

		String movie_code = (String) request.getSession().getAttribute("movie_code");
		String timetable_code = (String) request.getSession().getAttribute("timetable_code");
		String seat_code = request.getParameter("seat_number");
		String ticket_num=timetable_code+seat_code;
		double ageComm_pct;
		
		movieInfo.setMovie_code(movie_code);
		movieInfo = MovieDAO.getInstance().selectOne(movieInfo);
		
		if(memberInfo.getAge()<19) {
			ageComm_pct=0.6;
		}else {
			ageComm_pct=1.0;
		}
		String final_price=request.getParameter("final_price");
		final_price.replaceAll(".0", "");
		int final_price2 = Integer.parseInt(final_price);
		
		//객체에 값들 담아줌.
		movie_bookingVo.setTicket_num(ticket_num);
		movie_bookingVo.setTimetable_code(timetable_code);
		movie_bookingVo.setId(memberInfo.getId());
		movie_bookingVo.setSeat_code(seat_code);
		movie_bookingVo.setAgeComm_pct(ageComm_pct);
		movie_bookingVo.setFinal_price(final_price2);
		
		Movie_BookingDAO.getInstance().insert(movie_bookingVo);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
