package com.ola.timeApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.ws.http.HTTPException;

// This class enables creation GET request to the server.
public class HttpClient {

    private String addressUrl;
    private String timezone;
    String response;

    HttpClient(String adr){
        this.addressUrl = adr;
        this.timezone = "";
    }

    HttpClient(String adr, String t){
        this.addressUrl = adr;
        this.timezone = t;
    }

    public String HttpRequest() throws IOException {
        URL url = new URL(this.addressUrl + this.timezone); // create url address
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();    // start connection
        // set request parameters
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Content-Type", "application/json");

        // if we get a 200 response code
        if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            this.response = in.readLine();
            in.close();

        }
        else throw new HTTPException(httpConnection.getResponseCode()); // if not, throw a HTTP exception

        return response;
    }
}