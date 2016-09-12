package knox.book;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleBookFetch {

    /*private void getBookMetadataForISBN(String isbn) {
        try {
            URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn);
            requestMetadata(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }*/

    private void getBooksMetadataForAuthor(String author) {
        try {
            URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=inauthor:" + author.replace(" ", "+") +
                    "&filter=paid-ebooks&subject:fiction&&maxResults=20");
            populateLibrary(requestMetadata(url), author);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private JSONArray requestMetadata(URL url) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            JSONParser jsonParser = new JSONParser();
            JSONObject bookMeta = (JSONObject) jsonParser.parse(in);
            System.out.println("TotalResult:" + bookMeta.get("totalItems"));
            return (JSONArray) bookMeta.get("items");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void populateLibrary(JSONArray items, String author) {
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
                System.out.println(book);
            }
        }
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

    private String getISBN(JSONArray jsonArray) {
        if (jsonArray != null) {
            JSONObject identifier = (JSONObject) jsonArray.get(0);
            if (identifier.get("type").equals("ISBN_13")) {
                return (String) identifier.get("identifier");
            } else {
                identifier = (JSONObject) jsonArray.get(1);
                return (String) identifier.get("identifier");
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        GoogleBookFetch googleBookFetch = new GoogleBookFetch();
        googleBookFetch.getBooksMetadataForAuthor("Dan Brown");
    }
}
