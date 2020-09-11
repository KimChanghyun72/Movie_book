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
		
		public ArrayList<TheaterVO> selectAll(TheaterVO theaterVO) {
			TheaterVO resultVO = null;
			ArrayList<TheaterVO> list = new ArrayList<TheaterVO>();
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "SELECT theater_code, screen_name, theater_name "
						+ "FROM theater";
				pstmt = conn.prepareStatement(sql);
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
