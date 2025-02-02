import splitwise.Group;
import splitwise.TransactionController;
import splitwise.User;

import java.util.Calendar;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! use my split-wise app");

        var user1 = new User();
        var user2 = new User();
        var user3 = new User();
        var user4 = new User();

        var group1 = new Group();
        var group2 = new Group();

        group1.addUser(user1);
        group1.addUser(user2);
        group1.addUser(user3);

        group2.addUser(user4);
        group2.addUser(user2);

        TransactionController.addTransaction(user1, Set.of(user1, user2, user3),  100D, 2024, Calendar.DECEMBER, 12, group1);

        TransactionController.addTransaction(user2, Set.of(user1, user2),  1000D, 2024, Calendar.DECEMBER, 13, group1);

        TransactionController.addTransaction(user4, Set.of(user4, user2),  1500D, 2024, Calendar.DECEMBER, 15, group2);


        System.out.println(user2.getBalanceSheet());
        System.out.println(group2.getBalanceSheetForUser(user2));
    }
}