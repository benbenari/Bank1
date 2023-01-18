import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank{
    List<IAccount> newList;
    public Bank() {
        this.newList = new ArrayList<>();
    }
    @Override
    public void OpenAccount(IAccount account) {
        this.newList.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for(int i = 0; i < this.newList.size(); i++) {
            int currentANValue = this.newList.get(i).getAccountNumber();
            if (currentANValue == accountNumber) {
                double currentBalance = this.newList.get(i).getCurrentBalance();
                if(currentBalance >= 0) {
                    this.newList.remove(i);
                } else {
                    System.out.println("The account is not closed due to debt");
                }
                break;
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return this.newList;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> debt = new ArrayList<>();
        for (int i = 0; i < this.newList.size(); i++) {
            if (this.newList.get(i).getCurrentBalance() < 0) {
                debt.add(this.newList.get(i));
            }
        }
        return debt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> above = new ArrayList<>();
        for (int i = 0; i < this.newList.size(); i++) {
            if (this.newList.get(i).getCurrentBalance() > balanceAbove) {
                above.add(this.newList.get(i));
            }
        }
        return above;
    }
}