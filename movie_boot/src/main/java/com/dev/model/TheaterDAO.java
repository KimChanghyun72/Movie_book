package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class TheaterDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	//싱글톤
		static TheaterDAO instance;
		public static TheaterDAO getInstance() {
			if(instance==null)
				instance=new TheaterDAO();
			return instance;
		}
		
		public ArrayList<TheaterVO> selectAll(String movie_code) {
			TheaterVO resultVO = null;
			ArrayList<TheaterVO> list = new ArrayList<TheaterVO>();
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "SELECT theater_code, screen_name, theater_name "
						+ " FROM theater ";
						if(movie_code!=null) {
							sql += "where theater_code in "
									+ " (select distinct theater_code from timetable where movie_code = ?)";
						}
				
				pstmt = conn.prepareStatement(sql);
				if(movie_code!=null) {
					pstmt.setString(1, movie_code);
				}
				rs = pstmt.executeQuery();
				while(rs.next()) {
					resultVO = new TheaterVO();
					
					resultVO.setTheater_code(rs.getString("theater_code"));
					resultVO.setScreen_name(rs.getString("screen_name"));
					resultVO.setTheater_name(rs.getString("theater_name"));
					
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
