package Jan_16.helloworld;

public class BitShiftOperEx {
    public static void main(String[] args) {
        int val = 1;
        System.out.println("Origin : "+Integer.toBinaryString(val));
        System.out.println("val << 1:"+Integer.toBinaryString(val<<1));
        System.out.println("val << 1:"+Integer.toBinaryString(val>>4));
    }

}
