package JavaStudy.Mar_11.NSH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class KakaoDaoImpl extends BaseDao implements KakaoDao {
	
	// 생성자
	public KakaoDaoImpl(String dbUser, String dbPass) {
		super(dbUser, dbPass);
	}
	
	@Override
	public boolean insert(KakaoVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO kakao " +
			"(no, id, name, password)" +
					"VALUES(seq_kakao_pk.nextval, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  vo.getId());
			pstmt.setString(2,  vo.getName());
			pstmt.setString(3,  vo.getPassword());
			
			insertedCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.err.println("ERROR: "+e.getMessage());
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return insertedCount == 1;
	}

	@Override
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM kakao WHERE no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			deletedCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				System.err.println("ERROR: "+e.getMessage());
			}
		}
		
		return deletedCount == 1;
	}

	@Override
	public KakaoVo login(String id, String password) {
		KakaoVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT no, id, name, password FROM kakao WHERE id=? AND password=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Long no = rs.getLong(1);
				String idVal = rs.getString(2);
				String name = rs.getString(3);
				String passwordVal = rs.getString(4);
				
				vo = new KakaoVo(idVal, name, passwordVal);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return vo;
		
		
	}

	@Override
	public boolean check(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int checkCount = 0;
		
		try {
			conn = getConnection();
			String sql = "SELECT id FROM kakao WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			checkCount = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0==checkCount;
	}

}
