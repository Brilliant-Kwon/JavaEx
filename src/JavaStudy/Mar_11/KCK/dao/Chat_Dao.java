package JavaStudy.Mar_11.KCK.dao;

import JavaStudy.Mar_05.KCK.vo.Chat_Vo;

import java.util.List;

public interface Chat_Dao {

    public List<Chat_Vo> getList();

    public boolean insert(Chat_Vo vo);

    public boolean delete(Long no);

    public String match(String id, String pw);

}
