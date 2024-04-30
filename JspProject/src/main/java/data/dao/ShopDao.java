package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.ShopDto;
import db.common.MysqlConnect;

public class ShopDao {
	MysqlConnect connect = new MysqlConnect();

	public void insertShop(ShopDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;

		String sql="""
				insert into myshop (sname,sprice,scount,scolor,sphoto,writeday)
				values (?,?,?,?,?,now())
				""";
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getSprice());
			pstmt.setInt(3, dto.getScount());
			pstmt.setString(4, dto.getScolor());
			pstmt.setString(5, dto.getSphoto());
			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert 오류: "+e.getMessage());
		} finally {
			connect.dbClose(pstmt, conn);
		}
	}

	public List<ShopDto> getShopDatas(){
		List<ShopDto> list = new Vector<ShopDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;

		String sql = "select * from myshop order by shopidx desc";
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				ShopDto dto=new ShopDto();
				//db에서 가져와서 dto에 넣기
				dto.setShopidx(rs.getString("shopidx"));
				dto.setSname(rs.getString("sname"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setScount(rs.getInt("scount"));
				dto.setScolor(rs.getString("scolor"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select 오류: "+e.getMessage());
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	
	public ShopDto getSangpum(int shopidx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String sql="select * from myshop where shopidx=?";
		
		//ShopDto dto = new ShopDto();//한개의 데이터셋만 가져오기 때문에 밖에서 선언해도 된다.
		//하지만 if문 안에서 선언해도 상관없다.
		ShopDto dto = null;//아예 if 문 안에서 선언해버리면 마지막  return dto; 에서 dto가 if문 안의 지역변수로 인식되기 때문에 작동X
		//미리 선언만 해주고 if문 안에서 객체생성을 해준다.
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, shopidx);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ShopDto();
				
				dto.setShopidx(rs.getString("shopidx"));
				dto.setSname(rs.getString("sname"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setScount(rs.getInt("scount"));
				dto.setScolor(rs.getString("scolor"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void updateShop(ShopDto dto) {
		String sql="update myshop set sname=?,scolor=?,sprice=?,scount=?,sphoto=? where shopidx=?";
		Connection conn=null;
		PreparedStatement pstmt = null;
		conn = connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2,dto.getScolor());
			pstmt.setInt(3, dto.getSprice());
			pstmt.setInt(4, dto.getScount());
			pstmt.setString(5, dto.getSphoto());
			pstmt.setString(6, dto.getShopidx());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
	}
	public void deleteShop(ShopDto dto) {
		String sql="delete from myshop where shopidx=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getShopidx());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
}













