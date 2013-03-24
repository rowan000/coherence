package com.chattech.database.service;

import com.chattech.database.service.Query;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 27/01/2013
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class QueryBuilder {

    public static Query attributeEquals(String name, String value) {
        Query query = new Query();
        query.addAttribute(name, value);
        return query;
    }
}
