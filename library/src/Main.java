package library.src;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to the Library Management System!");
        
        Library library = Library.getInstance();
        System.out.println("Library instance created: " + library);

        library.addBook(new Book("author1", "title1", "fantasy"));

        library.addBook(new Book("author2", "title2", "action"));
        library.addBook(new Book("author2", "title2", "action"));

        library.addBook(new Book("author2", "title3", "mystery"));
        library.addBook(new Book("author2", "title3", "mystery"));
        library.addBook(new Book("author2", "title3", "mystery"));
        library.addBook(new Book("author2", "title3", "mystery"));
        library.addBook(new Book("author2", "title3", "mystery"));

        Member member1 = new Member("member1", "member1@gmail.com", "1234567000");
        Member member2 = new Member("member2", "member2@gmail.com", "1234567001");
        Member member3 = new Member("member3", "member3@gmail.com", "1234567002");

        library.registerMember(member1);

        library.registerMember(member2);
        library.registerMember(member3);

        library.getAvailableBooksByTitle("title1");

        library.getAvailableBooksByAuthor("author2");

        member1.borrowBook("title1");

        library.getAvailableBooksByTitle("title1");

        member1.returnBook("title1", new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-25"));

        library.getAvailableBooksByTitle("title1");

        member1.borrowBook("title1");
        member1.borrowBook("title2");
        member1.borrowBook("title3");
        member1.borrowBook("title3");
        member1.borrowBook("title3");
        member1.borrowBook("title3");
    }
}