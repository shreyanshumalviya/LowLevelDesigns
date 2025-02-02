package splitwise;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Transaction {
    private User payer;
    private Set<User> users;
    private Double amount;
    private Date date;

    public Transaction(User payer, Set<User> users, Double amount, Date date) {
        this.payer = payer;
        this.users = users;
        this.amount = amount;
        this.date = date;
    }

    Double getShareOfUser(User user){
        if(!users.contains(user)) return 0D;
        if (user != payer) {
            return 0 - amount/users.size();
        }else{ // if user is payer
            return amount - (amount/users.size())*(users.size()-1);
        }
    }

    public Set<User> getUsers() {
        return users;
    }


    public Date getDate() {
        return date;
    }
}
