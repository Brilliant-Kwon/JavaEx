package JavaStudy.Mar_11.YSH;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class UserDAOImpl implements UserDAO {
	private Connection getConnection()  throws SQLException {
		Connection conn=null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(dburl,"bituser","bituser");
			
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("JDBC 드라이버 로드 실패 ");
		}
		return conn;
	}
	
	@Override
	public boolean insert(UserVo userVo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt=null;
		int insertedCount = 0;
		try {
			conn=getConnection();
			String sql="INSERT INTO KAKAO VALUES(SEQ_KAKAO_PK.NEXTVAL, ?, ?, ?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getId());
			pstmt.setString(2, userVo.getName());
			pstmt.setString(3, userVo.getPassword());
			
			
			insertedCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.err.println("ERROR:"+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				System.out.println("ERROR:"+e.getMessage());
				// TODO: handle exception
			}
		}
		
		return insertedCount == 1;
	}
	@Override
	public boolean search(UserVo userVo) {
		// TODO Auto-generated method stub
		return false;
	}

}
