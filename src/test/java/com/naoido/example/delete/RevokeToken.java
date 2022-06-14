package com.naoido.example.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class RevokeToken {
    public static void main(String[] args) throws JsonProcessingException {
        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        System.out.println("----------------------------");
        System.out.println("Token    : " + osuApiClient.getToken());

        //revoke token
        osuApiClient.revokeToken();

        System.out.println("----------------------------");
        System.out.println("EndPoint : " + osuApiClient.getEndPoint());
        System.out.println("Response : " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("Token    : " + osuApiClient.getToken());
        System.out.println("----------------------------");

        //Server returned HTTP response code: 401
        String userName = "Naoido";
        osuApiClient.getUser(userName);
    }
}
