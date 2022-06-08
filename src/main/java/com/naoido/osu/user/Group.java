package com.naoido.osu.user;

public class Group {
    private int id;
    private String identifier;
    private String name;
    private String shortName;
    private String description;
    private String colour;

    public Group() {
    }

    public int getId() {
        return this.id;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getColour() {
        return this.colour;
    }
}
