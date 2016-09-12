package knox.book;

import knox.database.MySQLConnector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GoogleBookFetch {
    private MySQLConnector mySQLConnector = null;

    public GoogleBookFetch() {
        mySQLConnector = new MySQLConnector("192.168.134.55", "3306", "BookBase", "root", "");
    }

    private void getBooksMetadataForAuthor(String author) {
        try {
            URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=inauthor:" + author.replace(" ", "+") +
                    "&filter=paid-ebooks&subject:fiction&&maxResults=40");
            List<Book> books = populateBookList(requestMetadata(url), author);
            int bookCount = populateBookDatabase(books);
            System.out.println(bookCount + "Book(s) added for Author " + author);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private JSONArray requestMetadata(URL url) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            JSONParser jsonParser = new JSONParser();
            JSONObject bookMeta = (JSONObject) jsonParser.parse(in);
            //System.out.println("TotalResult:" + bookMeta.get("totalItems"));
            return (JSONArray) bookMeta.get("items");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<Book> populateBookList(JSONArray items, String author) {
        List<Book> books = new ArrayList<>();
        for (Object item : items) {
            JSONObject volumeInfo = (JSONObject) ((JSONObject) item).get("volumeInfo");
            String bookAuthor = jsonArrayToString((JSONArray) volumeInfo.get("authors"));
            if (bookAuthor.contains(author)) {
                Book book = new Book();
                book.setTitle((String) volumeInfo.get("title"));
                book.setPublisher((String) volumeInfo.get("publisher"));
                book.setDescription((String) volumeInfo.get("description"));
                book.setAuthors(bookAuthor);
                book.setCategories(jsonArrayToString((JSONArray) volumeInfo.get("categories")));
                book.setISBN(getISBN((JSONArray) volumeInfo.get("industryIdentifiers")));
                books.add(book);
            }
        }
        return books;
    }

    private String jsonArrayToString(JSONArray jsonArray) {
        if (jsonArray != null) {
            int arraySize = jsonArray.size();
            String arrayString = (String) jsonArray.get(0);
            if (arraySize > 1) {
                int i = 1;
                while (i < arraySize) {
                    arrayString = arrayString + ", " + jsonArray.get(i++);
                }
            }
            return arrayString;
        } else {
            return null;
        }
    }

    private long getISBN(JSONArray jsonArray) {
        if (jsonArray != null) {
            JSONObject identifier = (JSONObject) jsonArray.get(0);
            if (!identifier.get("type").equals("ISBN_13")) {
                identifier = (JSONObject) jsonArray.get(1);
            }
            return Long.parseLong(identifier.get("identifier").toString());
        } else {
            return 55;
        }
    }

    private int populateBookDatabase(List<Book> books) {
        int bookCount = books.size();
        if(books != null && bookCount > 0) {
            String insertQuery = "INSERT INTO books (Title, Authors, Categories, Publisher, Description, ISBN) VALUES";
            for (Book book : books) {
                insertQuery += " (\"" + book.getTitle() + "\", \"" + book.getAuthors() + "\", \"" +
                        book.getCategories() + "\", \"" + book.getPublisher() + "\", \"" +
                        book.getDescription().replace("'", "\\\'") + "\", " + book.getISBN() + "), ";
            }
            insertQuery = insertQuery.substring(0, insertQuery.length() - 2);
            insertQuery = insertQuery + ";";
            mySQLConnector.executeQuery(insertQuery);
        }
        return bookCount;
    }

    public static void main(String[] args) {
        GoogleBookFetch googleBookFetch = new GoogleBookFetch();
        googleBookFetch.getBooksMetadataForAuthor("Dan Brown");
    }
}
