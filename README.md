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
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

//GET(https://osu.ppy.sh/api/v2/beatmaps/lookup?{checksum? filename? id?})
Beatmap lookupBeatmap = osuApiClient.getLookupBeatMap(Parameter.of("id", 1033882));
BeatmapSet beatmapSet = lookupBeatmap.getBeatmapSet();

System.out.println("BeatmapNameUnicode: " + beatmapSet.getTitleUnicode());
System.out.println("BeatmapCreator: " + beatmapSet.getCreator());
System.out.println("MusicArtist: " + beatmapSet.getArtist());
System.out.println("BPM: " + lookupBeatmap.getBPM());
System.out.println("BeatmapURL: " + lookupBeatmap.getUrl());
```
output
```
BeatmapNameUnicode: Transform (Original Mix)
BeatmapCreator: Monstrata
MusicArtist: IAHN
BPM: 174
BeatmapURL: https://osu.ppy.sh/beatmaps/1033882
```
## Usage2(getUser)
```java
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

//GET(https://osu.ppy.sh/api/v2/users/{userID})
User user = osuApiClient.getUser("Naoido");
Statistics statistics = user.getStatistics();

System.out.println("Name: " + user.getUserName());
System.out.println("PP: " + statistics.getPerformancePoint());
System.out.println("GlobalRank: " + statistics.getGlobalRank());
System.out.println("CountryRank: " + statistics.getCountryRank());

for (Map.Entry<String, Integer> rank : statistics.getGradeCounts().getTreeMap().entrySet()) {
    System.out.println(rank.getKey() + ": " + rank.getValue());
}
```
output
```
Name: Naoido
PP: 3034
GlobalRank: 183014
CountryRank: 5872
A: 213
S: 109
SH: 9
SS: 4
SSH: 0
```
## Usage3(getUserBeatmapScore)
```java
OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

//GET(https://osu.ppy.sh/api/v2/beatmaps/{beatmapID}/scores/users/{userID})
UserBeatmapScore userBeatmapScore = osuApiClient.getUserBeatmapScore(2480902, 9144414);

User naoido = userBeatmapScore.getUser();
Score score = userBeatmapScore.getScore();
Beatmap beatmap = userBeatmapScore.getBeatmap();
System.out.println("iconURL: " + naoido.getAvatarUrl());
System.out.println("Score: " + score.getScore());
System.out.println("PP: " + score.getPerformancePoint());
System.out.println("BPM: " + beatmap.getBPM());
System.out.println("BeatmapURL: " + beatmap.getUrl());
```
output
```
iconURL: https://a.ppy.sh/9144414?1565053015.jpeg
Score: 5534210
PP: 206.007
BPM: 206
BeatmapURL: https://osu.ppy.sh/beatmaps/2480902
```