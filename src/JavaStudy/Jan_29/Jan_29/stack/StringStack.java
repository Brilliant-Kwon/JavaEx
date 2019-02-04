package JavaStudy.Jan_29.Jan_29.stack;

public class StringStack implements Stack {
    String stack;
    StringStack ss = null;
    private int index = 0;

    public StringStack(String stack) {
//        ss = new StringStack(null);
        this.stack = stack;
    }

//    class Node {
//        Object data;
//        Node next;
//
//        Node(Object data) {
//            this.data = data;
//            this.next = null;
//        }
//    }

    @Override
    public int length() {
        int len = 0;
        StringStack temp = ss;
        while (true) {
            if (temp.ss != null) {
                temp = ss.ss;
            } else {
                len = temp.index;
                break;
            }
        }
        return len;
    }

    @Override
    public Object pop() {
        if (index > 0) {
            System.out.println("POP : " + ss.stack);
//            index--;
            return ss;
        } else {
            System.out.println("보유 스택이 없습니다.");
            return null;
        }
    }

    @Override
    public boolean push(Object object) {
        ss = (StringStack) object;
        System.out.println("PUSH : " + ss.stack);
//        Node newNode = new Node(object);
//        newNode.next =
        ss.index = index + 1;
        return false;
    }
}
