package Fab_15_JDBC.dao.dao;

import Fab_15_JDBC.dao.vo.PhoneBookVO;

import java.util.List;

public interface PhoneBookDAO {
    public List<PhoneBookVO> getList();
    public PhoneBookVO get(Long id);

    public boolean insert(PhoneBookVO phoneBookVO);

    public boolean delete(Long id);

    public boolean update(PhoneBookVO phoneBookVO);
}
