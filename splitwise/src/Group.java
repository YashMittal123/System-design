package splitwise.src;
import java.util.*;

public class Group {
    private String name;
    private List<User> members;

    public Group(String name, List<User> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void recordExpense(User payer, double amount, String description, List<User> involvedUsers) {
        System.out.print("Recording expense: " + description + " of amount " + amount + " paid by " + payer.getName() + " for people: ");

        for (User user : involvedUsers) {
            System.out.print(user.getName() + ", ");
        }

        System.out.println();

        double splitAmount = amount / involvedUsers.size();
        for (User user : involvedUsers) {
            if (!user.equals(payer)) {
                payer.pay(user, splitAmount, description);
            }
        }
        
    }

    public void getGroupBalance() {
        System.out.println("Group Balance for " + this.name + ":");
        for (User user : members) {
            System.out.println("- " + user.getName());
            for (User other : members) {
                if (!user.equals(other)) {
                    user.getBalance(other);
                }
            }
        }
    }
}
