package JavaStudy.Jan_29.YSH;
//스택의 원소로는 문자열을 갖은 StringStack클래스를 작성 하여라 그리고 StringStack 에 문자열을 삽입하고 
//다시 pop하여 문자열을 출력하는 메소드를 구현하여 프로그램을 완성하라 

public class StackMain {
	public static void main(String[] args) {
		StringStack st=new StringStack();
		st.push("123");
		st.push("456");
		st.push("789");
		
		
		System.out.println(st.stk.size());

		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
