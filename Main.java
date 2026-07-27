import java.time.LocalDate;

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

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
}

// Physical copy in the library
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

    public String getBarcode() { return barcode; }
    public Main getBook() { return book; }
    public String getRackNumber() { return rackNumber; }
    
    public synchronized BookStatus getStatus() { return status; }
    public synchronized void setStatus(BookStatus status) { this.status = status; }

    public synchronized LocalDate getDueDate() { return dueDate; }
    public synchronized void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}