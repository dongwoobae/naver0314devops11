package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.SawonDto;
import db.common.MysqlConnect;

public class SawonDao {
	MysqlConnect db = new MysqlConnect();
	
	//추가
	public void insertSawon(SawonDto dto) {
		String sql = """
				insert into mysawon (name,buseo,age,addr,photo,gender,birthday)
				 values(?,?,?,?,?,?,?)
				""";
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		try {
			//바인딩
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	//전체 출력
	public List<SawonDto> getAllSawons(){
		List<SawonDto> list = new Vector<SawonDto>();
		SawonDto dto =null;
		String sql="""
				select * from mysawon order by name asc
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//매번 새로운 dto를 선언해서 만드는 것보다 위에서 객체생성후 재사용이 더 좋음
			while(rs.next()) {				
				dto = new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthday(rs.getString("birthday"));
				//dto에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//한개 반환
	public SawonDto getData(int num) {
		SawonDto dto = null;
		String sql="""
				select * from mysawon where num = ?
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩 해주고 실행을 해야 오류가 안남
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new SawonDto();
				//dto 셋업
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthday(rs.getString("birthday"));
				//한개만 반환할거라 list 없이 해당 dto만 반환
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public void updateData(SawonDto dto) {
		
		String sql="""
				update mysawon set name=?,buseo=?,age=?,addr=?,photo=?,gender=?,birthday=? where num=? 
				""";
		Connection conn=null;
		PreparedStatement pstmt = null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5,dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			pstmt.setInt(8, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteSawon(int num) {
		String sql="""
			delete from mysawon where num=?
				""";
		Connection conn=null;
		PreparedStatement pstmt =null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
}
