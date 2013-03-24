package com.chattech.database.storage;

import com.chattech.database.service.Query;

/**
 * Database storage defines read and write operations to an underlying storage
 */
public interface DatabaseStorage {

    void store(Class storageClass, Object toStore);

    Object read(Class storageClass, Query query);
}
