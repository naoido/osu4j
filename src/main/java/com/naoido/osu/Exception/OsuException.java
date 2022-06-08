package com.naoido.osu.Exception;

public class OsuException extends Exception{
    private final String msg;

    public OsuException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

}
