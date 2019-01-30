package JavaStudy.Jan_29.StringStack;

public class StringStack implements Stack {

    private int stackLength;
    private String[] strs;

    public StringStack(int length) {//스택 길이를 먼저 받아서 생성
        strs = new String[length];
        stackLength = 0;
    }

    @Override
    public int length() {
        return stackLength;
    }

    @Override
    public Object pop() {
        String popstr;
        if (stackLength > 0) {
            popstr = strs[stackLength - 1];
            stackLength--;
        } else
            popstr = "스택이 없습니다.";

        return popstr;
    }

    @Override
    public boolean push(Object object) {
        if (stackLength == strs.length)
            return false;
        else {
            strs[stackLength] = (String) object;
            stackLength++;
            return true;
        }
    }
}
