package library.src;

import java.util.UUID;

enum BookStatus {
    AVAILABLE, 
    ISSUED
};

public class Book {
    UUID id;
    String author;
    String title;
    String genre;
    BookStatus status;

    public Book(String author, String title, String genre) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.status = BookStatus.AVAILABLE;
    }
}
