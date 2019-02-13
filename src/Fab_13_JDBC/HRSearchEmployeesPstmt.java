package Fab_13_JDBC;

import java.sql.*;
import java.util.Scanner;

public class HRSearchEmployeesPstmt {
    public static void main(String[] args) {
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
//        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 이름 또는 철자 : ");
        String name = sc.nextLine();

        try {
            //2.드라이버로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //3.Connection 얻기
            conn = DriverManager.getConnection(dburl, "HR", "HR");
            System.out.println("Connection : " + conn);
            System.out.println("연결 성공!");
            //4.PreparedStatement 생성
//            stmt = conn.createStatement();

            String sql = "SELECT first_name || ' ' || last_name as name, email, phone_number, hire_date FROM employees " +
                    "WHERE lower(first_name) LIKE ? OR lower(last_name) LIKE ?";
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name.toLowerCase() + "%");
            pstmt.setString(2, "%" + name.toLowerCase() + "%");

            //5.결과값을 얻기 -> ResultSet
            rs = pstmt.executeQuery();
            System.out.println("\n 검색결과 출력\n=========================================================================================");
            System.out.printf("%-25s %-15s %-20s %-30s\n", "name", "email", "phone_number", "hire_date");
//            System.out.println("name,   email,  phone_number,   hire_date");
            System.out.println("=========================================================================================");
            int count = 0;
            while (rs.next()) {
                String emp0 = rs.getString("name");     //이름 + 성
//                String emp1 = rs.getString("last_name");
                String emp2 = rs.getString("email");    //이메일
                String emp3 = rs.getString("phone_number");//전화번호
                String emp4 = rs.getString("hire_date");//고용일

                System.out.printf("%-25s %-15s %-20s %-30s\n", emp0, emp2, emp3, emp4);
                count++;
            }
            System.out.println("출력된 행은 " + count + " 개 입니다.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾지 못하였습니다..");
        } catch (SQLException e) {
            System.err.println("SQL Error!");
            System.err.println("ERROR : " + e.getMessage());
        } finally {
            //6.닫기
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("SQL Error!");
                System.err.println("ERROR : " + e.getMessage());
            }
        }
    }
}
