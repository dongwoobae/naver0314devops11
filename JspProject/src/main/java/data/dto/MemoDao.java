package data.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dao.MemoDto;
import db.common.MysqlConnect;

public class MemoDao {
	MysqlConnect db=new MysqlConnect();
	
	//추가 
	public void insertMemo(MemoDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		String sql="""
				insert into mymemo (uploadphoto,title,content,writeday) values (?,?,?,now());
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getUploadPhoto());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
			pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//출력
	public List<MemoDto> getAllMemo(){
		List<MemoDto> list = new Vector<>();
		MemoDto dto=null;
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="""
				select * from mymemo order by num desc
				""";
		try {
			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto=new MemoDto();
				dto.setNum(rs.getInt("num"));
				dto.setUploadPhoto(rs.getString("uploadphoto"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
			
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//상세보기
	public MemoDto getData(int num) {
		MemoDto dto=null;
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="""
				select * from mymemo where num=?
				""";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new MemoDto();
				dto.setNum(rs.getInt("num"));
				dto.setUploadPhoto(rs.getString("uploadphoto"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}		
		return dto;
	}
}
