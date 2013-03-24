package com.chattech.database;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 21/01/2013
 * Time: 22:03
 * To change this template use File | Settings | File Templates.
 */
public class SimpleObject {
    private long key;
    private String name;

    public SimpleObject(long key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
