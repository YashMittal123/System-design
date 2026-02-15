package splitwise.src;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        System.out.println("Welcome to Splitwise!");

        User user1 = new User("user1");
        User user2 = new User("user2");

        user1.pay(user2, 100, "food");
        user1.pay(user2, 50, "food");
        user2.pay(user1, 80, "tickets");

        user1.getBalance(user2);

        user1.getLendings(user2);

        user1.getBorrowings(user2);

        user2.pay(user1, 70, "settle");

        user2.getBalance(user1);

        // checking group functionality
        User user3 = new User("user3");
        User user4 = new User("user4");

        Group group1 = new Group("Goa Trip", new ArrayList<>(List.of(user1,user2, user3, user4)));

        group1.recordExpense(user1, 400, "Food", List.of(user1, user2, user3, user4));
        group1.recordExpense(user4, 1000, "Hotel", List.of(user1, user2, user3, user4));

        group1.getGroupBalance();
    }
}
