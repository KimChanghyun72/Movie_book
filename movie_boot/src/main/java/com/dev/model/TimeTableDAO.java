package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class TimeTableDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	static TimeTableDAO instance;
	public static TimeTableDAO getInstance() {
		if(instance==null)
			instance=new TimeTableDAO();
		return instance;
	}
	
	public ArrayList<TimeTableVO> selectAll(String theater_code, String movie_code) {
		TimeTableVO resultVO = null;
		ArrayList<TimeTableVO> list = new ArrayList<TimeTableVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT TimeTable_code, theater_code, movie_code, start_time, end_time, screening_date FROM TimeTable "
					+ "where theater_code = ? and movie_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theater_code);
			pstmt.setString(2, movie_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new TimeTableVO();
				
				resultVO.setTimetable_code(rs.getString("timetable_code"));
				resultVO.setTheater_code(rs.getString("theater_code"));
				resultVO.setMovie_code(rs.getString("movie_code"));
				resultVO.setStart_time(rs.getString("start_time"));
				resultVO.setEnd_time(rs.getString("end_time"));
				resultVO.setScreening_date(rs.getString("screening_date"));
				
				list.add(resultVO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
	return list;	
	}
}
