package com.foodora.countryapp.webapp;

import com.foodora.countryapp.models.Country;
import com.foodora.countryapp.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Imports the Data from remote server and loads it into the
 * database it happens one time when the server is starts
 *
 * @author Mohamad Alaloush'
 */
@Component
public class RemoteDataBaseLoader implements CommandLineRunner {


    @Autowired
    private CountryService countryService;

    public static final String myUrl = "http://pastebin.com/raw/943PQQ0n";

    /**
     * helper method for retrieving the url response and transforming it from binary to string
     *
     * @param urlToRead
     * @return
     * @throws IOException
     */
    public static String getHTML(String urlToRead) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line + "\n");
        }
        rd.close();
        return result.toString();
    }

    /**
     * the function that will be run from spring automatically after the context was loaded
     * <p>
     * it is basically a main method for spring apps
     *
     * @param args
     * @throws IOException
     */
    public void run(String... args) throws IOException {

//      parsing the data and persisting it
        String s = getHTML(myUrl);
        String[] arr = s.split("\n");
        String[] newarr = Arrays.copyOfRange(arr, 3, arr.length - 1);
        for (String s1 : newarr) {
            String[] s2 = s1.split("   ");
            Country country = new Country(s2[0], s2[1]);
            countryService.saveCountry(country);
        }
    }
}
