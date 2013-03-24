package com.chattech.database.service;

import com.chattech.database.service.EntityCollection;
import com.chattech.database.service.Query;
import com.chattech.database.storage.DatabaseStorage;
import com.chattech.database.storage.FileDatabaseStorage;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 21/01/2013
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class JsonEntityCollection implements EntityCollection {

    private Class collectionClass;
    private List<Object> entitiesCache = new ArrayList<Object>();
    private DatabaseStorage storage = new FileDatabaseStorage();

    public JsonEntityCollection(Class collectionClass) {
        this.collectionClass = collectionClass;
    }

    @Override
    public void insert(Object persistentObject) {
        entitiesCache.add(persistentObject);
        storage.store(collectionClass, persistentObject);

    }

    @Override
    public Object findOne() {
        if(entitiesCache.isEmpty()){
            return null;
        }
        return entitiesCache.get(0);
    }

    @Override
    public Set find(Query query) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int size() {
        return entitiesCache.size();
    }
}
