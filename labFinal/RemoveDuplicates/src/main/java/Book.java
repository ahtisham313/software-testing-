public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int year;
    private int copies;

    public Book(String ISBN, String title, String author, int year, int copies) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
        this.copies = copies;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
