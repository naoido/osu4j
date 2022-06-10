# OsuApiWrapper for Java (osu4j)

# Example Code
## Build Client
```java
//Build OsuApiClient
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

System.out.println("Token: " + osuApiClient.getToken());
```
output
```
Token: Bearer {Token}
```
## Usage1(getLookupBeatmap)
```java
//Build OsuApiClient
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

//GET(https://osu.ppy.sh/api/v2/beatmaps/lookup?{checksum? filename? id?})
Beatmap lookupBeatmap = osuApiClient.getLookupBeatmap(Parameter.of("id", 1033882));
BeatmapSet beatmapSet = lookupBeatmap.getBeatmapSet();

System.out.println("----------------------------");
System.out.println("EndPoint: " + osuApiClient.getEndPoint());
System.out.println("Response: " + osuApiClient.getResponse());
System.out.println("----------------------------");

System.out.println("BeatmapNameUnicode: " + beatmapSet.getTitleUnicode());
System.out.println("BeatmapCreator    : " + beatmapSet.getCreator());
System.out.println("MusicArtist       : " + beatmapSet.getArtist());
System.out.println("BPM               : " + lookupBeatmap.getBPM());
System.out.println("BeatmapURL        : " + lookupBeatmap.getUrl());

System.out.println("----------------------------");
```
output
```
----------------------------
EndPoint: /beatmaps/lookup
Response: {"beatmapset_id":484689...
----------------------------
BeatmapNameUnicode: Transform (Original Mix)
BeatmapCreator    : Monstrata
MusicArtist       : IAHN
BPM               : 174
BeatmapURL        : https://osu.ppy.sh/beatmaps/1033882
----------------------------
```
## Usage2(getUser)
```java
//Build OsuApiClient
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

String userName = "Naoido";

//GET(https://osu.ppy.sh/api/v2/users/{userID})
User user = osuApiClient.getUser(userName, Mode.OSU);
Statistics statistics = user.getStatistics();

System.out.println("----------------------------");
System.out.println("EndPoint: " + osuApiClient.getEndPoint());
System.out.println("Response: " + osuApiClient.getResponse());
System.out.println("----------------------------");

System.out.println("Name        : " + user.getUserName());
System.out.println("PP          : " + statistics.getPerformancePoint());
System.out.println("GlobalRank  : " + statistics.getGlobalRank());
System.out.println("CountryRank : " + statistics.getCountryRank());
System.out.println("PlayTimes   : " + statistics.getPlayTime());

System.out.println("----------------------------");

//Print grade counts
for (Map.Entry<String, Integer> rank : statistics.getGradeCounts().getTreeMap().entrySet()) {
    System.out.println(String.format("%-12s", rank.getKey()) + ": " + rank.getValue());
}

System.out.println("----------------------------");
```
output
```
----------------------------
EndPoint: /users/Naoido/osu
Response: {"avatar_url":"https...
----------------------------
Name        : Naoido
PP          : 3034
GlobalRank  : 183171
CountryRank : 5874
PlayTimes   : 834898
----------------------------
A           : 213
S           : 109
SH          : 9
SS          : 4
SSH         : 0
----------------------------
```
## Usage3(getBeatmapScores)
```java
//Build OsuApiClient
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

int beatmapId = 592367;

//GET(https://osu.ppy.sh/api/v2/beatmaps/{beatmapID}/scores?{mode? mods? type?})
List<Score> userScores = osuApiClient.getBeatmapScores(beatmapId, Parameter.of(Mode.OSU));

System.out.println("----------------------------");
System.out.println("EndPoint: " + osuApiClient.getEndPoint());
System.out.println("Response: " + osuApiClient.getResponse());
System.out.println("----------------------------");

for (Score userScore: userScores) {
    User user = userScore.getUser();
    
    System.out.println("UserName : " + user.getUserName());
    System.out.println("Accuracy : " + userScore.getAccuracy() + "%");
    System.out.println("Score    : " + userScore.getScore());
    System.out.println("Rank     : " + userScore.getRank());
    System.out.println("PP       : " + userScore.getPerformancePoint());;
    
    System.out.println("----------------------------");
}
```
output
```
----------------------------
EndPoint: /beatmaps/592367/scores
Response: {"scores":[{"accuracy":1...
----------------------------
UserName : Varvalian
Accuracy : 100.0%
Score    : 46304251
Rank     : XH
PP       : 435.757
----------------------------
UserName : WillCookie
Accuracy : 100.0%
Score    : 46302051
Rank     : XH
PP       : 435.757
----------------------------
UserName : Mercurius
Accuracy : 99.86%
Score    : 46277669
Rank     : SH
PP       : 426.049
----------------------------
...
```

## \> [Other Usages](https://github.com/naoido/osu4j/tree/master/src/test/java/com/naoido/example)