package JavaStudy.Mar_11.NSH;


public interface KakaoDao {
	// 메서드 선언
	public KakaoVo login(String id, String password);
	public boolean insert(KakaoVo vo);
	public boolean delete(Long id);
	public boolean check(String id);
	
}
