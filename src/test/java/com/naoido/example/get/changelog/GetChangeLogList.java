package com.naoido.example.get.changelog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.changelog.*;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetChangeLogList {
    public static void main(String[] args) throws JsonProcessingException {
        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        //GET(https://osu.ppy.sh/api/v2/changelog/{stream}/{version})
        ChangeLogList changeLogList = osuApiClient.getChangeLogList();

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        for (ChangeLog changeLog: changeLogList.getBuilds()) {
            System.out.println("ID           : " + changeLog.getId());
            System.out.println("Version      : " + changeLog.getDisplayVersion());
            System.out.println("CreatedAt    : " + changeLog.getCreatedAt());

            System.out.println("----------------------------");

            for (Entry entry: changeLog.getEntries()) {
                GithubUser githubUser = entry.getGithubUser();

                System.out.println("Repository   : " + entry.getRepository());
                System.out.println("Type         : " + entry.getType());
                System.out.println("GithubUser   : " + githubUser.getDisplayName());
                System.out.println("OsuUserName  : " + githubUser.getOsuUserName());
                System.out.println("Message      : " + entry.getMessage());

                System.out.println("----------------------------");
            }
        }

        ChangeLogList.Search search = changeLogList.getSearch();

        System.out.println("Limit        : " + search.getLimit());
        System.out.println("----------------------------");

    }
}
