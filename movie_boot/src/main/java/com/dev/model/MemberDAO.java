package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dev.common.ConnectionManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
		return instance;
	}
	
	//회원 전체 조회 
	public ArrayList<MemberVO> selectAll(MemberVO memberVO) {
		MemberVO resultVO = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PASSWORD, PHONE_NUMBER, AGE "
					+ " FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new MemberVO();
				
				resultVO.setId(rs.getString("id"));
				resultVO.setPassword(rs.getString("password"));
				resultVO.setPhone_number(rs.getString("phone_number"));
				resultVO.setAge(rs.getInt("age"));
				
				
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
	return list;	
	}
	
	//회원 한 건 조회
	public MemberVO selectOne(MemberVO memberVO) {
		MemberVO resultVO = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PASSWORD, PHONE_NUMBER, AGE "
					+ "FROM MEMBER WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberVO.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new MemberVO();
				
				resultVO.setId(rs.getString("id"));
				resultVO.setPassword(rs.getString("password"));
				resultVO.setPhone_number(rs.getString("phone_number"));
				resultVO.setAge(rs.getInt("age"));
				
			}else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
	return resultVO;	
	}
	
	
	
	//회원탈퇴
	public void delete(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM MEMBER WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of delete
	
	//회원정보 업데이트
	public void update(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE MEMBER SET PASSWORD = ? ,PHONE_NUMBER = ? WHERE ID= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPassword());
			pstmt.setString(2, memberVO.getPhone_number());
			pstmt.setString(3, memberVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of update
	
	
	//insert (회원가입)
	public int insert(MemberVO memberVO) {
		int r=0;
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.sql 구문 실행
			String sql = "INSERT INTO MEMBER (ID, PASSWORD, PHONE_NUMBER,AGE) "
						+ " values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getPhone_number());
			pstmt.setInt(4, memberVO.getAge());
			
			r = pstmt.executeUpdate();
			//3.결과 처리
				System.out.println(r+"건이 처리됨.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//4.연결 해제
			//db에 접속가능한 세션의 수는 제한됨. 따라서 접속끝나면 연결해제해줘야 됨.
			ConnectionManager.close(conn);
		}
		return r;
	
	}//end of insert
	
	
		
}
