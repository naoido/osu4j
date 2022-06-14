package com.naoido.example.get.changelog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.changelog.ChangeLog;
import com.naoido.osu4j.model.changelog.Entry;
import com.naoido.osu4j.model.changelog.GithubUser;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetLookupChangeLog {
    public static void main(String[] args) throws JsonProcessingException {
        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        String version = "2022.612.0";

        //GET(https://osu.ppy.sh/api/v2/changelog/{version}?{key? message_formats[]?})
        ChangeLog changeLog = osuApiClient.getLookupChangeList(version);

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("ID           : " + changeLog.getId());
        System.out.println("Version      : " + changeLog.getDisplayVersion());
        System.out.println("CreatedAt    : " + changeLog.getCreatedAt());
        System.out.println("StreamName   : " + changeLog.getUpdateStream().getName());

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
}
