package Jan_22.collection.list;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        //스택 선언
        Stack<Integer> stack = new Stack<>();

        //값을 10개 담아보기
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        //마지막 input 객체 확인
        //peek 확인만 하고 삭제는 하지 않는다.
        System.out.println(stack.peek());
        System.out.println(stack);

        //pop : 마지막 Input 객체를 반환하고 해당 객체를 스택에서 제거
        System.out.println(stack.pop());
        System.out.println(stack);

        while (true) {//pop을 할 때에는 비어있는지 확인부터 해야 오류가 발생하지 않음
            if (!stack.empty())
                System.out.println(stack.pop());
            else
                break;
        }
    }
}
