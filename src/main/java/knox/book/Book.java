package knox.book;

public class Book {
    private String title;
    private String authors;
    private String categories;
    private String publisher;
    private String description;
    private String isbn;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", categories='" + categories + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", ISBN='" + isbn + '\'' +
                '}';
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

}
