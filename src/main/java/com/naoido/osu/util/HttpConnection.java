package com.naoido.osu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class HttpConnection {

    public static String getOutput(HttpURLConnection connection) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {sb.append(line);}
        br.close();
        return sb.toString();
    }
}
