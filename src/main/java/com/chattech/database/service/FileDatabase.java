package com.chattech.database.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 13/01/2013
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class FileDatabase implements DatabaseService {
    Map<Class, EntityCollection> collections = Maps.newHashMap();
    @Override
    public List<String> getCollectionNames() {
        List<String> collectionNames = Lists.newArrayList();
        for(Class clazz : collections.keySet()){
            collectionNames.add(clazz.getName());
        }
        return collectionNames;
    }

    @Override
    public EntityCollection getCollection(Class collectionName) {
        EntityCollection collection = new JsonEntityCollection(collectionName);
        collections.put(collectionName, collection);
        return collection;
    }
}
