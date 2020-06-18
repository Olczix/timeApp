package com.ola.timeApp;

import com.google.gson.Gson;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) {

        // address of the time api
        String addressUrl = "http://worldtimeapi.org/api/timezone/";

        // entering timezone
        System.out.println("Enter timezone: ");
        Scanner scanner = new Scanner(System.in);
        String timezone = scanner.nextLine();


        try {
            // no timezone has been entered
            if (timezone.length() == 0) throw new HTTPException(-1);    // so catch the exception

            HttpClient http = new HttpClient(addressUrl, timezone); // creating an object which represents Http response
            String response = http.HttpRequest();   // getting response

            // converting the response to the Json Object
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

            // converting received datetime to desired format (time only)
            Date time = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(jsonObject.getDatetime().substring(0,23));
            System.out.println(time.getHours() + ":" + (time.getMinutes()<10 ? "0": "") + time.getMinutes() + ":" + time.getSeconds());

        } catch (HTTPException e) {

            try {   // when an empty argument or wrong timezone has been entered
                HttpClient http = new HttpClient(addressUrl);
                String response = http.HttpRequest();
                // convert the response to a list with all available timezones
                Gson gson = new Gson();
                List<String> timezones = gson.fromJson(response, new ArrayList<String>().getClass());

                System.out.println("Available timezones below:");
                for (String t : timezones)
                    System.out.println(t);

            } catch (HTTPException ex) {
                System.out.println("An error on the server's side - error code is " + e.getStatusCode());
            } catch (IOException ex) {
                System.out.println("An error on the client's side");
            }
        } catch (ParseException e) {
            System.out.println("An error while parsing the time");
        } catch (IOException e) {
            System.out.println("An error on the client's side");
        }

    }
}
