package com.chattech.database;

import com.chattech.database.service.DatabaseService;
import com.chattech.database.service.FileDatabase;
import com.chattech.database.service.InMemoryDatabase;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 13/01/2013
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
public class Database<T, K> {

    public static DatabaseService createInMemory() {
        return new InMemoryDatabase();
    }

    public static DatabaseService createPersistentDatabase() {
        return new FileDatabase();
    }
}
