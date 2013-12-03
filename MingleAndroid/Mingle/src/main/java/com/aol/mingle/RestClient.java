package com.aol.mingle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class RestClient { 
	
    HttpURLConnection getConnection(String urlString) throws Exception {
        final URL url = new URL(urlString);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setUseCaches(false);
        httpCon.setAllowUserInteraction(false);

        return httpCon;
    }

    void get(HttpURLConnection httpCon) throws Exception {
        httpCon.setRequestMethod("GET");
        httpCon.setDoInput(true);
        httpCon.setDoOutput(false);

        httpCon.connect();
    }

    void post(HttpURLConnection httpCon, String payload) throws Exception {
        httpCon.setRequestMethod("POST");
        httpCon.setDoOutput(true);
        httpCon.setDoInput(true);

        httpCon.connect();
        httpCon.getOutputStream().write(payload.getBytes());
        httpCon.getOutputStream().close();
    }

    String getResponseAsString(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
            // System.out.println(line);
        }

        return stringBuilder.toString();
    }

    String buildErrorMessage(HttpURLConnection httpURLConnection) {
        String response1;
        try {
            response1 = httpURLConnection.getResponseMessage();
        } catch (Exception e) {
            response1 = null;
        }

        String response2;
        try {
            response2 = getResponseAsString(httpURLConnection.getErrorStream());
        } catch (Exception e) {
            response2 = null;
        }

        return response1 == null ? response2 : response2 == null ? response1 : response1 + " -- " + response2;
    }
}
