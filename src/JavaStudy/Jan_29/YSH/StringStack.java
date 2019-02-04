package JavaStudy.Jan_29.YSH;

import java.util.ArrayList;

public class StringStack implements Stack{
	ArrayList<String> stk=new ArrayList<>();
	int top=-1;
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return stk.size();
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(top==-1)
			return "스택에 자료가없습니다.";
		else {
			stk.remove(top);
			top--;
			return (stk.size()+1)+"번째자료 팝!";
		}
	}

	@Override
	public boolean push(Object ob) {
		// TODO Auto-generated method stub
		stk.add((String)ob);
		top++;
		System.out.println((top+1)+"번째 푸쉬!");
		return true;
	}
	
}
