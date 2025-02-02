package splitwise;

import java.util.List;

public class BalanceSheet {
    private final double balance;
    private final List<BalanceSheetEntry> balanceSheetEntries;

    public BalanceSheet(List<Transaction> transactions, User user) {
        balanceSheetEntries = transactions.stream().map(t->new BalanceSheetEntry(t.getShareOfUser(user), t.getDate())).toList();
        balance = balanceSheetEntries.stream().mapToDouble(BalanceSheetEntry::getAmount).sum();
    }

    @Override
    public String toString() {
        var response = new StringBuilder();
        response.append("Balance Sheet: \n");
        response.append(String.format("%15s    %s", "Amount", "Date")).append("\n");
        for (var entry :
                balanceSheetEntries) {
            response.append(entry.toString()).append("\n");
        }
        response.append(String.format("Balance: %.2f ", balance));
        return response.toString();
    }
}
