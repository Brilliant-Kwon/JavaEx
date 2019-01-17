package Jan_17.reftype;

public class MainArgs {
    public static void main(String[] args) {
        System.out.println("args length : " + args.length);
        for(int i = 0; i< args.length; i++){
            System.out.printf("args[%d] = %s\n",i, args[i]);
        }
    }
}
