package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class MovieDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	static MovieDAO instance;
	public static MovieDAO getInstance() {
		if(instance==null)
			instance=new MovieDAO();
		return instance;
	}
	public MovieVO selectOne(MovieVO movieVO) {
		MovieVO resultVO = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT Movie_code, movie_name, movie_time, movie_director, movie_price, movie_poster, movie_grade "
					+ "FROM movie WHERE MOVIE_CODE=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieVO.getMovie_code());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new MovieVO();
				
				resultVO.setMovie_code(rs.getString("movie_code"));
				resultVO.setMovie_name(rs.getString("movie_name"));
				resultVO.setMovie_time(rs.getString("movie_time"));
				resultVO.setMovie_director(rs.getString("movie_director"));
				resultVO.setMovie_price(rs.getInt("movie_price"));
				resultVO.setMovie_poster(rs.getString("movie_poster"));
				resultVO.setMovie_grade(rs.getString("movie_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
	return resultVO;	
	}
	
	public ArrayList<MovieVO> selectAll(MovieVO MovieVO) {
		MovieVO resultVO = null;
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT Movie_code, movie_name, movie_time, movie_director, movie_price, movie_poster, movie_grade "
					+ "FROM movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new MovieVO();
				
				resultVO.setMovie_code(rs.getString("movie_code"));
				resultVO.setMovie_name(rs.getString("movie_name"));
				resultVO.setMovie_time(rs.getString("movie_time"));
				resultVO.setMovie_director(rs.getString("movie_director"));
				resultVO.setMovie_price(rs.getInt("movie_price"));
				resultVO.setMovie_poster(rs.getString("movie_poster"));
				resultVO.setMovie_grade(rs.getString("movie_grade"));
				
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
