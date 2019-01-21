package Jan_21.Practice03_1.problem03;

public class Account {
    private String accountNo;
    private int balance;

    //생성자 작성
    public Account(String accountNo) {
        this.accountNo = accountNo;
        this.balance = 0;
    }

    //필요한 메소드 작성
    public void deposit(int money) {
        setBalance(this.balance+=money);
    }

    public void withdraw(int money) {
        setBalance(this.balance-=money);
    }

    public void showBalance() {
        System.out.println(getBalance());
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
