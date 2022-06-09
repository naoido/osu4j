package com.naoido.example;

import com.naoido.osu4j.OsuApiClient;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

class BuildOsuApiClient {
    public static void main(String[] args) {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        System.out.println("BearerToken: " + osuApiClient.getToken());
        System.out.println("Response: " + osuApiClient.getResponse());
    }
}
