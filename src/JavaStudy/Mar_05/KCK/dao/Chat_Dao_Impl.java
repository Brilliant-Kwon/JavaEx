package JavaStudy.Mar_05.KCK.dao;

import JavaStudy.Mar_05.KCK.vo.Chat_Vo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Chat_Dao_Impl extends BaseDao implements Chat_Dao {
    public Chat_Dao_Impl(String dbUser, String dbPass) {
        super(dbUser, dbPass);
    }

    @Override
    public List<Chat_Vo> getList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Chat_Vo> list = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM chat_app";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insert(Chat_Vo vo) {
        return false;
    }

    @Override
    public boolean delete(Long no) {
        return false;
    }

    @Override
    public String match(String id, String pw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String nickname = null;

        try {
            conn = getConnection();
            String sql = "SELECT nickname FROM chat_app WHERE id=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                nickname = rs.getString(1);
            }
            System.out.println("닉네임 : " + nickname);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nickname;
    }
}
