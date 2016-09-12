package knox.book;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ISBNPlusBookFetch {
    private static final String APP_ID = "cc16fd0a";
    private static final String APP_KEY = "55ae8c4e69325681698e67ca8fbaa739";
    private void getBooksMetadataForAuthor(String author) {
        try {
            URL url = new URL("https://api-2445581351187.apicast.io:443/search?q=business&p=1&app_id=" + APP_ID +
                    "&app_key=" + APP_KEY);
            requestMetadata(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void requestMetadata(URL url) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            JSONParser jsonParser = new JSONParser();
            JSONObject bookMeta = (JSONObject) jsonParser.parse(in);
            System.out.println(bookMeta);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ISBNPlusBookFetch isbnPlusBookFetch = new ISBNPlusBookFetch();

        isbnPlusBookFetch.getBooksMetadataForAuthor("James");
    }
}