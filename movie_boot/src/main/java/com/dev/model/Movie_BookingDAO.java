package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class Movie_BookingDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;

	//싱글톤
	static Movie_BookingDAO instance;

	public static Movie_BookingDAO getInstance() {
		if (instance == null)
			instance = new Movie_BookingDAO();
		return instance;
	}
	
	public ArrayList<String> selectSeatNum(String timetable_code){
		String seatNum = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT seat_code "
					+ " FROM movie_booking "
					+ " where timetable_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, timetable_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				seatNum = rs.getNString("seat_code");
				list.add(seatNum);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<Movie_BookingVo> selectAll() {
		Movie_BookingVo resultVo = null;
		ArrayList<Movie_BookingVo> list = new ArrayList<Movie_BookingVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ticket_num, timetable_code, id, seat_code, ageComm_pct, final_price "
					+ "FROM movie_booking";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVo = new Movie_BookingVo();

				resultVo.setTicket_num(rs.getString("ticket_num"));
				resultVo.setTimetable_code(rs.getString("timetable_code"));
				resultVo.setId(rs.getString("id"));
				resultVo.setSeat_code(rs.getString("seat_code"));
				resultVo.setAgeComm_pct(rs.getInt("ageComm_pct"));
				resultVo.setFinal_price(rs.getInt("final_price"));

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

	public Movie_BookingVo selectOne(Movie_BookingVo movie_bookVo) {
		Movie_BookingVo resultVo = null;

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ticket_num, timetable_code, id, seat_code, ageComm_pct, final_price "
					+ "FROM movie_booking where ticket_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_bookVo.getTicket_num());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVo.setTicket_num(rs.getString("ticket_num"));
				resultVo.setTimetable_code(rs.getString("timetable_code"));
				resultVo.setId(rs.getString("id"));
				resultVo.setSeat_code(rs.getString("seat_code"));
				resultVo.setAgeComm_pct(rs.getInt("ageComm_pct"));
				resultVo.setFinal_price(rs.getInt("final_price"));
			} else {
				System.out.println("no data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo;
	}

	public void delete(Movie_BookingVo movie_bookVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM movie_booking WHERE ticket_num =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_bookVo.getTicket_num());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}

		
	}//end of delete
	
	public void deleteId(Movie_BookingVo movie_bookVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM movie_booking WHERE id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_bookVo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}

		
	}//end of delete

	public void update(Movie_BookingVo movie_bookVo) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE movie_booking SET seat_code = ? WHERE ticket_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_bookVo.getSeat_code());
			pstmt.setString(2, movie_bookVo.getTicket_num());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}

	}//end of update

	public void insert(Movie_BookingVo movie_bookVo) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.sql 구문 실행
			String sql = "INSERT INTO movie_booking (ticket_num, timetable_code, id, seat_code, ageComm_pct, final_price) "
					+ " values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_bookVo.getTicket_num());
			pstmt.setString(2, movie_bookVo.getTimetable_code());
			pstmt.setString(3, movie_bookVo.getId());
			pstmt.setString(4, movie_bookVo.getSeat_code());
			pstmt.setDouble(5, movie_bookVo.getAgeComm_pct());
			pstmt.setInt(6, movie_bookVo.getFinal_price());
			int r = pstmt.executeUpdate();
			//3.결과 처리
			System.out.println(r + "건의 예매가 처리됨.");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4.연결 해제
			//db에 접속가능한 세션의 수는 제한됨. 따라서 접속끝나면 연결해제해줘야 됨.
			ConnectionManager.close(conn);
		}

	}//end of insert

}
