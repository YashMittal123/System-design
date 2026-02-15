package library.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Member {
    UUID id;
    String name;
    String email;
    String phoneNumber;
    List<Ticket> activeTickets;
    List<Ticket> closedTickets;

    public Member(String name, String email, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        activeTickets = new ArrayList<>();
        closedTickets = new ArrayList<>();
    }

    public void borrowBook(String title) {
        Library library = Library.getInstance();
        Book bookToBorrow = library.getBookAvailable(title);

        if (this.activeTickets.size() >= 5) {
            System.out.println("Cannot borrow more than 5 books at a time.");
            return;
        }

        if (bookToBorrow!= null) {
            library.borrowBook(bookToBorrow, this);
            System.out.println("Book borrowed successfully: " + bookToBorrow.id);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(String title, Date returnDate) {
        Library library = Library.getInstance();

        Ticket ticketToClose = this.activeTickets.stream()
                .filter(ticket -> ticket.book.title.equals(title) && ticket.status == TicketStatus.ISSUED)
                .findFirst()
                .orElse(null);

        this.activeTickets.remove(ticketToClose);
        
        if (ticketToClose != null) {
            library.returnBook(title);

            int dueAmount = ticketToClose.closeTicket(returnDate);
            this.closedTickets.add(ticketToClose);

            System.out.println("Book returned successfully: " + title + ". Due amount: " + dueAmount);
        } else {
            System.out.println("No active ticket found for the book: " + title);
        }
    }
}
