package Jan_23.collection.practice.extra02.problem01;

public class Sub extends Operator {


    @Override
    public void setValue(int a, int b) {
        this.x = a;
        this.y = b;
    }

    @Override
    public int calculate() {
        return x-y;
    }
}
