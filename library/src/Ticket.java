package library.src;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

enum TicketStatus {
    ISSUED,
    RETURNED,
    OVERDUE
};

public class Ticket {
    UUID id;
    Member member;
    Book book;
    Date issueDate;
    Date returnDate;
    TicketStatus status;
    int dueAmount;

    public Ticket(Member member, Book book, Date issueDate) {
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.status = TicketStatus.ISSUED;
        this.dueAmount = 0;
    }

    public int closeTicket(Date returnDate) {
        this.returnDate = returnDate;
        this.status = TicketStatus.RETURNED;

        System.out.println("Issue Date: " + this.issueDate);
        System.out.println("Return Date: " + this.returnDate);

        long NoOfDays = ChronoUnit.DAYS.between(
                this.issueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                this.returnDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );

        this.dueAmount = 10 * (int) NoOfDays;
        return this.dueAmount;
    }
}
