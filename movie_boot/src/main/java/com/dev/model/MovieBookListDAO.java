package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class MovieBookListDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;

	
	static MovieBookListDAO instance;

	public static MovieBookListDAO getInstance() {
		if (instance == null)
			instance = new MovieBookListDAO();
		return instance;
	}
	
	public ArrayList<MovieBookListVO> selectAll(String id) {
		MovieBookListVO resultVo = null;
		ArrayList<MovieBookListVO> list = new ArrayList<MovieBookListVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select a.ticket_num, a.seat_code, a.final_price, c.theater_name, d.movie_name " + 
					"from movie_booking a, timetable b, theater c, movie d " + 
					"where (a.timetable_code = b.timetable_code) " + 
					"and (b.theater_code=c.theater_code) " + 
					"and (b.movie_code=d.movie_code)"
					+ "and a.id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVo = new MovieBookListVO();

				resultVo.setTicket_num(rs.getString("ticket_num"));
				resultVo.setSeat_code(rs.getString("seat_code"));
				resultVo.setFinal_price(rs.getInt("final_price"));
				resultVo.setTheater_name(rs.getString("theater_name"));
				resultVo.setMovie_name(rs.getString("movie_name"));

				list.add(resultVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
}
