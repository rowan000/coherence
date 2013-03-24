package com.chattech.database.storage;

import com.chattech.database.service.Query;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;

import java.io.*;

/**
 * Understands how to read and write database objects to a file
 */
public class FileDatabaseStorage implements DatabaseStorage {

    @Override
    public void store(Class collectionClass, Object toStore) {
        //serialize data
        File file = new File(collectionClass.getName());
        try {
            FileOutputStream fileStream = new FileOutputStream(file);

            JsonFactory jsonFactory = new BsonFactory();
            ObjectMapper mapper = new ObjectMapper(jsonFactory);
            mapper.writeValue(fileStream, toStore);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read(Class storageClass, Query query) {
        //deserialize data
        JsonFactory jsonFactory = new BsonFactory();
        ObjectMapper mapper = new ObjectMapper(jsonFactory);

        File file = new File(storageClass.getName());
        Object deserialized = null;

        try {
            FileInputStream fileStream = new FileInputStream(file);
            deserialized = mapper.readValue(fileStream, storageClass);

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return deserialized;
    }
}
