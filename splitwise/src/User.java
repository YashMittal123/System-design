package splitwise.src;
import java.util.*;

public class User {
    private String name;
    private List<Transaction> lendings;
    private List<Transaction> borrowings;
    private Map<User, Double> balance;

    public User(String name) {
        this.name = name;
        this.lendings = new ArrayList<>();
        this.borrowings = new ArrayList<>();
        this.balance = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void pay(User user, double amount, String description) {
        System.out.println(this.name + " paid " + amount + " to " + user.getName());

        Transaction transaction = new Transaction(this, user, amount, description);
        this.lendings.add(transaction);
        user.borrowings.add(transaction);

        this.balance.put(user, this.balance.getOrDefault(user, 0.0) + amount);
        user.balance.put(this, user.balance.getOrDefault(this, 0.0) - amount);
    }

    public void getBalance(User user) {
        double amount = this.balance.getOrDefault(user, 0.0);
        if (amount > 0) {
            System.out.println(this.name + " is owed " + amount + " by " + user.getName());
        } else if (amount < 0) {
            System.out.println(this.name + " owes " + (-amount) + " to " + user.getName());
        } else {
            System.out.println(this.name + " and " + user.getName() + " are settled up.");
        }
    }

    public void getLendings(User user) {
        System.out.println(this.name + " has lent the following amounts to " + user.getName() + ":");
        for (Transaction transaction : lendings) {
            if (transaction.getTo().equals(user)) {
                System.out.println("- " + transaction.getAmount() + " for " + transaction.getDescription());
            }
        }
    }

    public void getBorrowings(User user) {
        System.out.println(this.name + " has borrowed the following amounts from " + user.getName() + ":");
        for (Transaction transaction : borrowings) {
            if (transaction.getFrom().equals(user)) {
                System.out.println("- " + transaction.getAmount() + " for " + transaction.getDescription());
            }
        }
    }
}
