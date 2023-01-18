public class StandardAccount implements IAccount {
    int myaccountnum;
    double climit;
    double mybalance;

    @Override
    public void Deposit(double amount) {
        this.mybalance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (this.mybalance == this.climit) {
            return 0.0;
        } else if (amount > this.mybalance - this.climit) {
            this.mybalance = this.climit;
            return this.mybalance - this.climit;
        } else {
            this.mybalance = this.mybalance - amount;
            return amount;
        }
    }


    public StandardAccount(int accountNumber, double creditLimit) {
        if (creditLimit > 0) {
            this.climit = 0;
        } else {
            this.climit = creditLimit;
        }
        this.myaccountnum = accountNumber;
        this.mybalance = 0.0;
    }




    @Override
    public int getAccountNumber() {
        return this.myaccountnum;
    }

    @Override
    public double getCurrentBalance() {
        return this.mybalance;
    }



}
