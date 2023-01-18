public class PremiumAccount implements IAccount {
    int myaccountnum;
    double mybalance;

    public PremiumAccount(int accountNumber) {
        this.myaccountnum = accountNumber;
        this.mybalance = 0.0;
    }

    @Override
    public double Withdraw(double amount) {
        this.mybalance = this.mybalance - amount;
        return amount;

    }

    @Override
    public void Deposit(double amount) {
        this.mybalance += amount;
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
