package Fab_13_JDBC;
//1. 클래스 임포트

import java.sql.*;

//JDBC 접속 테스트
public class ConnectionTest {
    public static void main(String[] args) {
        //Database 연결 정보 만들기
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; //연결 문자열, DBMS 마다 다름.
        String dbuser = "HR";//스키마 유저
        String dbpass = "HR";//패스워드

        Connection conn = null;


        try {
            //2.드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");//동적 로드 위해서 사용

            //3.Connection
            conn = DriverManager.getConnection(dburl, dbuser, dbpass);
            System.out.println("Connection : " + conn);
            System.out.println("연결 성공!");
        } catch (ClassNotFoundException e) { // Class.forName 오류
            System.err.println("JDBC 드라이버를 찾지 못하였습니다..");
        } catch (SQLException e) { // 연결부분 에러
            System.err.println("SQL Error!");
            System.err.println("ERROR : " + e.getMessage());
        }finally {
            //6.연결 해제
            try {
                conn.close();
            } catch (SQLException e) { //연결 해제 부분 에러
                System.err.println("SQL Error!");
                System.err.println("ERROR : " + e.getMessage());
            }
        }

    }
}
