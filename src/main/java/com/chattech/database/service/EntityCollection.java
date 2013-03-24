package com.chattech.database.service;

import com.chattech.database.service.Query;

import java.util.Set;


public interface EntityCollection<T> {

    void insert(T persistentObject);

    T findOne();

    Set<T> find(Query<T> query);

    int size();
}
