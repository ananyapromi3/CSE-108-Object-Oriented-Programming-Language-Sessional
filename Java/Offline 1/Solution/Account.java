public class Account {

    private int number;
    private String customer;
    private double balance;
    // you are not allowed to add any more class variables here

    // you are not allowed to write any other constructor
    public Account(int number, String customer, double balance) {
        this.number = number;
        this.customer = customer;
        this.balance = balance;
    }

    // add your code here
    public double getBalance() {
        return this.balance;
    }

    public String getCustomer() {
        return this.customer;
    }

    public int getNumber() {
        return this.number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}