package Fab_13_JDBC;

import java.sql.*;

//1.java.sql import
public class SelectTest {
    public static void main(String[] args) {
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //2.드라이버로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //3.Connection 얻기
            conn = DriverManager.getConnection(dburl, "HR", "HR");
            System.out.println("Connection : " + conn);
            System.out.println("연결 성공!");
            //4.Statement 생성
            stmt = conn.createStatement();
            String sql = "SELECT department_id, department_name FROM departments";
            //5.결과값을 얻기 -> ResultSet
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String deptId = rs.getString(1);//컬럼 인덱스로 가져옴
                String deptName = rs.getString("department_name");//컬럼명으로 가져옴
                System.out.printf("%s\t:\t%s%n", deptId, deptName);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾지 못하였습니다..");
        } catch (SQLException e) {
            System.err.println("SQL Error!");
            System.err.println("ERROR : " + e.getMessage());
        } finally {
            //6.닫기
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("SQL Error!");
                System.err.println("ERROR : " + e.getMessage());
            }
        }

    }
}
