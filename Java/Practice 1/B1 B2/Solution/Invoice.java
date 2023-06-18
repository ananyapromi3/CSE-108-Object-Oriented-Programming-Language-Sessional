public class Invoice {
    int id;
    Customer customer;
    double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }
	
	// write set and get methods
    public void setId(int id){
        this.id = id;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public int getId(){
        return this.id;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public double getAmount(){
        return this.amount;
    }

	// write other methods to successfully run TestMain
    public int getCustomerId(){
        return this.customer.getId();
    }

    public String getCustomerName(){
        return this.customer.getName();
    }

    public int getCustomerDiscount(){
        return this.customer.getDiscount();
    }

    public  double getAmountAfterDiscount(){
        return this.amount-this.customer.getDiscount();
    }
}
