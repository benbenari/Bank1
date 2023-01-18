public class BasicAccount implements IAccount{

    private int myaccountnum;
    private double limitwithdraw;
    private double mybalance;
    private int countwithdraw;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.myaccountnum = accountNumber;
        this.limitwithdraw = withdrawalLimit;
        this.mybalance = 0.0;
        this.countwithdraw = 0;
    }



    @Override
    public void Deposit(double amount) {
        this.mybalance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if(this.countwithdraw > 0) {
            return 0.0;
        } else {
            this.countwithdraw++;
        }

        if(this.limitwithdraw < amount && this.limitwithdraw > this.mybalance) {
            double w = this.mybalance;
            this.mybalance = 0.0;
            return w;
        } else if(this.limitwithdraw < amount) {
            this.mybalance = this.mybalance - this.limitwithdraw;
            return this.limitwithdraw;
        } else {
            this.mybalance = this.mybalance - amount;
            return amount;
        }
    }

    @Override
    public double getCurrentBalance() {
        return this.mybalance;
    }

    @Override
    public int getAccountNumber() {
        return this.myaccountnum;
    }
}
