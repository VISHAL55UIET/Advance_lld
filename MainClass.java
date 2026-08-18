import java.time.LocalDate;
import java.util.Scanner;

enum BookStatus {
    AVAILABLE,
    RESERVED,
    LOANED,
    LOST
}

enum AccountStatus {
    ACTIVE,
    CLOSED,
    FROZEN
}

// Metadata representing a literary work
class Main {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    public Main(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
class BookItem {
    private final String barcode;
    private final Main book;
    private final String rackNumber;
    private BookStatus status;
    private LocalDate dueDate;

    public BookItem(String barcode, Main book, String rackNumber) {
        this.barcode = barcode;
        this.book = book;
        this.rackNumber = rackNumber;
        this.status = BookStatus.AVAILABLE;
        this.dueDate = null;
    }

    public String getBarcode() {
        return barcode;
    }

    public Main getBook() {
        return book;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public synchronized BookStatus getStatus() {
        return status;
    }

    public synchronized void setStatus(BookStatus status) {
        this.status = status;
    }

    public synchronized LocalDate getDueDate() {
        return dueDate;
    }

    public synchronized void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Book metadata input
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter publication year: ");
        int publicationYear = sc.nextInt();
        sc.nextLine();

        Main book = new Main(
                isbn,
                title,
                author,
                publicationYear
        );

        // Physical book copy input
        System.out.print("Enter barcode: ");
        String barcode = sc.nextLine();

        System.out.print("Enter rack number: ");
        String rackNumber = sc.nextLine();

        BookItem bookItem = new BookItem(
                barcode,
                book,
                rackNumber
        );

        // Output
        System.out.println("\n--- Book Details ---");
        System.out.println("ISBN: " + bookItem.getBook().getIsbn());
        System.out.println("Title: " + bookItem.getBook().getTitle());
        System.out.println("Author: " + bookItem.getBook().getAuthor());
        System.out.println("Publication Year: " + bookItem.getBook().getPublicationYear());

        System.out.println("\n--- Book Item Details ---");
        System.out.println("Barcode: " + bookItem.getBarcode());
        System.out.println("Rack: " + bookItem.getRackNumber());
        System.out.println("Status: " + bookItem.getStatus());
        System.out.println("Due Date: " + bookItem.getDueDate());
    }
}