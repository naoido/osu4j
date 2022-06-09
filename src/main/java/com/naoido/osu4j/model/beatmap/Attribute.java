package com.naoido.osu4j.model.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {
    @JsonProperty("star_rating")
    private double starRating;
    @JsonProperty("max_combo")
    private int maxCombo;
    @JsonProperty("aim_difficulty")
    private double aimDifficulty;
    @JsonProperty("speed_difficulty")
    private double speedDifficulty;
    @JsonProperty("flashlight_difficulty")
    private double flashLightDifficulty;
    @JsonProperty("slider_factor")
    private double sliderFactor;
    @JsonProperty("approach_rate")
    private double approachRate;
    @JsonProperty("overall_difficulty")
    private int overallDifficulty;


    public Attribute() {}

    public double getStarRating() {
        return this.starRating;
    }

    public int getMaxCombo() {
        return this.maxCombo;
    }

    public double getAimDifficulty() {
        return this.aimDifficulty;
    }

    public double getSpeedDifficulty() {
        return this.speedDifficulty;
    }

    public double getFlashLightDifficulty() {
        return this.flashLightDifficulty;
    }

    public double getSliderFactor() {
        return this.sliderFactor;
    }

    public double getApproachRate() {
        return this.approachRate;
    }

    public int getOverallDifficulty() {
        return this.overallDifficulty;
    }

    public static class Attributes {
        @JsonProperty("attributes")
        private Attribute attributes;

        public Attributes() {}

        public Attribute getAttribute() {
            return this.attributes;
        }
    }
}
