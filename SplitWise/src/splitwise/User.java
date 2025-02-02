package splitwise;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Transaction> transactions;

    public User() {
        this.transactions = new ArrayList<>();
    }

    public BalanceSheet getBalanceSheet(){
        return new BalanceSheet(transactions, this);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
