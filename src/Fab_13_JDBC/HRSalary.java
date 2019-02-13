package Fab_13_JDBC;

import java.sql.*;
import java.util.Scanner;

public class HRSalary {
    public static void main(String[] args) {
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("최소급여, 최대급여 입력(공백으로 구분하세요.) : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if (num1 > num2) {
            int temp;
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String min = Integer.toString(num1);
        String max = Integer.toString(num2);

        try {
            //2.드라이버로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //3.Connection 얻기
            conn = DriverManager.getConnection(dburl, "HR", "HR");
            System.out.println("Connection : " + conn);
            System.out.println("연결 성공!");
            //4.Statement 생성
            stmt = conn.createStatement();
            String sql = "SELECT first_name || ' ' || last_name as name, salary " +
                    "FROM employees WHERE salary <= " + max + " AND salary >= " + min;
            System.out.println("SQL : " + sql);

            //5.결과값을 얻기 -> ResultSet
            rs = stmt.executeQuery(sql);
            System.out.println("\n 검색결과 출력\n=========================================================================================");
            System.out.printf("%-25s %-10s\n", "name", "salary");
//            System.out.println("name,   email,  phone_number,   hire_date");
            System.out.println("=========================================================================================");
            while (rs.next()) {
                String emp0 = rs.getString("name");     //이름 + 성
                String emp1 = rs.getString("salary");

                System.out.printf("%-25s %-10s\n", emp0, emp1);
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
