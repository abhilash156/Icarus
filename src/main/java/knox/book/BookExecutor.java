package knox.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class BookExecutor {
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        try {
            URL filePath = ClassLoader.getSystemClassLoader().getResource("authorlist.txt");
            GoogleBookFetch googleBookFetch = new GoogleBookFetch();
            if(filePath != null) {
                FileReader fileReader = new FileReader(filePath.getPath());
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while (line != null) {
                    if(!line.equals("")) {
                        googleBookFetch.getBooksMetadataForAuthor(line);
                    }
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = new Date().getTime();
        System.out.println("ExecutionTime: " + (endTime - startTime)/1000 + " seconds");
    }
}
