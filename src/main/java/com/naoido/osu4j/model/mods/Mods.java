package com.naoido.osu4j.model.mods;

public class Mods {
    public static int getBitSet(Mod... mods) {
        int bitset = 0;
        long bit = 0;

        for (Mod mod: mods) {
            bit += mod.getBit();
        }
        bitset = Integer.parseInt(String.valueOf(bit), 10);

        return bitset;
    }
}
