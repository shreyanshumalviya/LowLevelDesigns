package splitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private final List<Transaction> transactions;
    private final Set<User> users;

    public Group() {
        this.transactions = new ArrayList<>();
        this.users = new HashSet<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Set<User> getUsers() {
        return users;
    }
    public BalanceSheet getBalanceSheetForUser(User user){
        return new BalanceSheet(transactions, user);
    }
}
