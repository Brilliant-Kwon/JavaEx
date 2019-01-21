package Jan_21.exceptions;

public class CustomArithmeticException extends ArithmeticException{
    private int num1;
    private int num2;

    public CustomArithmeticException(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
