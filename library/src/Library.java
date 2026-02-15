package library.src;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {
    public List<Member> members;
    public List<Book> books;
    public static Library instance;

    public Library() {
        // Initialize members and books arrays
        this.members = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void registerMember(Member member) {
        this.members.add(member);
    }

    public void getAvailableBooksByTitle(String title) {
        List<UUID> bookIds = new ArrayList<>();
        int count = 0;
        for (Book book : this.books) {
            if (book.title.equals(title) && book.status == BookStatus.AVAILABLE) {
                count++;
                bookIds.add(book.id);
            }
        }
        System.out.println("Found " + count + " books with title '" + title + "': " + bookIds);
    }

    public void getAvailableBooksByAuthor(String authorName) {
        List<UUID> bookIds = new ArrayList<>();
        int count = 0;
        for (Book book : this.books) {
            if (book.author.equals(authorName) && book.status == BookStatus.AVAILABLE) {
                count++;
                bookIds.add(book.id);
            }
        }
        System.out.println("Found " + count + " books with author '" + authorName + "': " + bookIds);
    }

    public Book getBookAvailable(String title) {
        for (Book book : this.books) {
            if (book.title.equals(title) && book.status == BookStatus.AVAILABLE) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(Book book, Member member) {
        book.status = BookStatus.ISSUED;
        Ticket ticket = new Ticket(member, book, new java.util.Date());
        member.activeTickets.add(ticket);
    }

    public void returnBook(String title) {
        for (Book book : this.books) {
            if (book.title.equals(title) && book.status == BookStatus.ISSUED) {
                book.status = BookStatus.AVAILABLE;
                break;
            }
        }
    }   
}
