package com.chattech.database.service;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 27/01/2013
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public class Query<T> {

    private Map<String, String> attributes = Maps.newHashMap();

    public void addAttribute(String name, String value) {
        attributes.put(name, value);
    }
}
