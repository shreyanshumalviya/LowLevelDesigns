package splitwise;

import java.util.Calendar;
import java.util.Set;

public class TransactionController {

    private static void addTransaction(Transaction transaction, Group group) {
        // user not in group
        if(group!=null) {
            var containsAll = group.getUsers().containsAll(transaction.getUsers());
            if (!containsAll) {
                throw new RuntimeException("User not in group");
            }
            group.addTransaction(transaction);
        }

        transaction.getUsers().forEach(user -> user.addTransaction(transaction));

    }

    public static void addTransaction(User payer, Set<User> users, double amount, int yyyy, int december, int dd, Group group) {
        var date1 = Calendar.getInstance();
        date1.set(yyyy, december, dd);
        var transaction = new Transaction(payer, users, amount, date1.getTime());
        addTransaction(transaction, group);
    }
}
