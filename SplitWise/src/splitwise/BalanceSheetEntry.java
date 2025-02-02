package splitwise;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BalanceSheetEntry {
    private final double amount;
    private final Date date;

    public BalanceSheetEntry(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        var df = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%15.2f    %s", amount, df.format(date));
    }
}
