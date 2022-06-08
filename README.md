# Example Code
```java
public class Example {


    public static void main(String[] args) throws OsuException, JsonProcessingException {
        Osu osu = new OsuBuilder(CLIENT_ID, CLIENT_SECRET).build();

        OsuApiResponse res = osu.getUser("Naoido");
        User user = res.getUser();
        UserStatistics statistics = user.getStatistics();

        System.out.println("Name: " + user.getUserName());
        System.out.println("PP: " + statistics.getPerformancePoint());
        System.out.println("GlobalRank: " + statistics.getGlobalRank());
        System.out.println("CountryRank: " + statistics.getCountryRank());

        for (Map.Entry<String, Integer> rank: statistics.getGradeCounts().getTreeMap().entrySet()) {
            System.out.println(rank.getKey() + ": " + rank.getValue());
        }
    }
}
```
