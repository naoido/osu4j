package com.naoido.osu4j.model.user.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.TreeMap;

public class GradeCounts {
    @JsonProperty("a")
    private int aRankCount;
    @JsonProperty("s")
    private int sRankCount;
    @JsonProperty("ss")
    private int ssRankCount;
    @JsonProperty("sh")
    private int silverSRankCount;
    @JsonProperty("ssh")
    private int silverSsRankCount;

    public GradeCounts() {}

    public TreeMap<String, Integer> getTreeMap() {
        return new TreeMap<>() {
            {
                put("A", GradeCounts.this.aRankCount);
                put("S", GradeCounts.this.sRankCount);
                put("SH", GradeCounts.this.silverSRankCount);
                put("SS", GradeCounts.this.ssRankCount);
                put("SSH", GradeCounts.this.silverSsRankCount);
            }
        };
    }

    public HashMap<String, Integer> getHashMap() {
        return new HashMap<>() {
            {
                put("A", GradeCounts.this.aRankCount);
                put("S", GradeCounts.this.sRankCount);
                put("SH", GradeCounts.this.silverSRankCount);
                put("SS", GradeCounts.this.ssRankCount);
                put("SSH", GradeCounts.this.silverSsRankCount);
            }
        };
    }

    public int getARankCount() {
        return this.aRankCount;
    }

    public int getSRankCount() {
        return this.sRankCount;
    }

    public int getSsRankCount() {
        return this.ssRankCount;
    }

    public int getSilverSRankCount() {
        return this.silverSRankCount;
    }

    public int getSilverSsRankCount() {
        return this.silverSsRankCount;
    }
}
