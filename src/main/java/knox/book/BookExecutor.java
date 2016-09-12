package knox.book;

public class BookExecutor {
    public static void main(String[] args) {
        GoogleBookFetch googleBookFetch = new GoogleBookFetch();
        googleBookFetch.getBooksMetadataForAuthor("Dan Brown");
    }
}
