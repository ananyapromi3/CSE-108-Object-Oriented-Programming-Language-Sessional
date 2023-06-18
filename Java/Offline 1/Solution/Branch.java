public class Branch {

    private int id;
    private String name;
    private Account[] accounts;
    private int accountCount;
    // add your code here
    // you are allowed to add variables here
    // there can be at most 20 branches
    static Branch[] branches = new Branch[20];
    static int branchCount = 0;

    // you are not allowed to write any other constructor
    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[10];
        // add your code here
        accountCount = 0;
        branches[branchCount++] = this;
    }

    // you are not allowed to modify this method
    public void addAccount(Account a) {
        accounts[accountCount++] = a;
    }

    // add your code here
    public double getBranchBalance() {
        double temp_balance = 0;
        for (int i = 0; i < accountCount; i++) {
            temp_balance += accounts[i].getBalance();
        }
        return temp_balance;
    }

    public Account getMinBalanceAccount() {
        double min = 0;
        int k = 0;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getBalance() < min) {
                min = accounts[i].getBalance();
                k = i;
            }
        }
        return accounts[k];
    }

    public static void transferBalance(Account a1, Account a2, double balance) {
        a1.setBalance(a1.getBalance() - balance);
        a2.setBalance(a1.getBalance() + balance);
    }

    public static void printAllBranchesInfo() {
        // Branch Id: 1, Branch Name: BR1
        // Account Number: 1, Customer Name: ACC1, Balance: actual balance
        for (int i = 0; i < branchCount; i++) {
            System.out.print("Branch Id: ");
            System.out.print(branches[i].id);
            System.out.print(", " + "Branch Name: ");
            System.out.println(branches[i].name);
            for (int j = 0; j < branches[i].accountCount; j++) {
                System.out.print("Account Number: ");
                System.out.print(branches[i].accounts[j].getNumber());
                System.out.print(", " + "Customer Name: ");
                System.out.print(branches[i].accounts[j].getCustomer());
                System.out.print(", " + "Balance: ");
                System.out.println(branches[i].accounts[j].getBalance());
            }
        }
    }

}
