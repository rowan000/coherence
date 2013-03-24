package com.chattech.database.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 13/01/2013
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public interface DatabaseService {

    List<String> getCollectionNames();
    EntityCollection getCollection(Class collectionClass);
}
