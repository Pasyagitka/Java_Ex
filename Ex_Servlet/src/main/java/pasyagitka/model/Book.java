package pasyagitka.model;

public class Book {
    public String book_name;
    public String author;
    public int publication_year;
    public int pages;

    public Book()     {    };

    public Book(String book_name, String author, int publication_year, int pages) {
        this.book_name = book_name;
        this.author = author;
        this.publication_year = publication_year;
        this.pages = pages;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", publication_year=" + publication_year +
                ", pages=" + pages +
                '}';
    }

    public String getAuthor() {
        return  author;
    }
}
