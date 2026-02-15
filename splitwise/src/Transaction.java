package splitwise.src;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private User from;
    private User to;
    private double amount;
    private String description;

    public Transaction(User from, User to, double amount, String description) {
        this.id = UUID.randomUUID();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.description = description;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}