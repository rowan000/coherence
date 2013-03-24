package com.chattech.database;

import com.chattech.database.service.DatabaseService;
import com.chattech.database.service.EntityCollection;
import com.chattech.database.service.Query;
import com.chattech.database.service.QueryBuilder;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 13/01/2013
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTests {



    //implement a database storage directory
    //file contains entity collection fields followed by bson entities
    //com.chattech.database.SimpleObject
    //nameRowan
    //nameDianna

    //when you write, you append to storage file
    //when you delete, you have to find the entity and remove it
    //when you get you have to read the file for matching attributes - lucene?



    @Test
    public void canCreateEntityCollection(){

        DatabaseService service = Database.createInMemory();
        List<String> collectionNames = service.getCollectionNames();
        assertEquals(0, collectionNames.size());

        EntityCollection entityCollection = service.getCollection(SimpleObject.class);
        collectionNames = service.getCollectionNames();
        assertEquals(1, collectionNames.size());
        assertEquals("SimpleObject", collectionNames.get(0));
        assertEquals(0, entityCollection.size());

    }

    @Test
    public void canInsertEntity(){
        DatabaseService service = Database.createInMemory();
        List<String> collectionNames = service.getCollectionNames();
        assertEquals(0, collectionNames.size());

        EntityCollection entityCollection = service.getCollection(SimpleObject.class);

        entityCollection.insert(new SimpleObject(0L, "Rowan"));
        assertEquals(1, entityCollection.size());

        entityCollection.insert(new SimpleObject(1L, "Dianna"));
        assertEquals(2, entityCollection.size());

    }

    @Test
    public void canFindOne(){
        DatabaseService service = Database.createInMemory();
        List<String> collectionNames = service.getCollectionNames();
        assertEquals(0, collectionNames.size());

        EntityCollection entityCollection = service.getCollection(SimpleObject.class);

        entityCollection.insert(new SimpleObject(0L, "Rowan"));
        assertEquals(1, entityCollection.size());

        entityCollection.insert(new SimpleObject(1L, "Dianna"));
        assertEquals(2, entityCollection.size());

        SimpleObject entity = (SimpleObject) entityCollection.findOne();

        assertEquals("Rowan", entity.getName());


    }

    @Test
    public void canFindByQuery(){
        DatabaseService service = Database.createInMemory();
        List<String> collectionNames = service.getCollectionNames();
        assertEquals(0, collectionNames.size());

        EntityCollection entityCollection = service.getCollection(SimpleObject.class);

        entityCollection.insert(new SimpleObject(0L, "Rowan"));
        assertEquals(1, entityCollection.size());

        entityCollection.insert(new SimpleObject(1L, "Dianna"));
        assertEquals(2, entityCollection.size());

        Query query = QueryBuilder.attributeEquals("name", "Rowan");

        List<SimpleObject> returned = Lists.newArrayList(entityCollection.find(query));

        assertEquals("Rowan", returned.get(0).getName());


    }

//    @Test
//    public void canRemoveEntity(){
//        DatabaseService service = Database.createInMemory();
//        List<String> collectionNames = service.getCollectionNames();
//        assertEquals(0, collectionNames.size());
//
//        EntityCollection entityCollection = service.getCollection("SimpleObject");
//
//        entityCollection.insert(new SimpleObject(0L, "Rowan"));
//        assertEquals(1, entityCollection.size());
//
//        entityCollection.insert(new SimpleObject(1L, "Dianna"));
//        assertEquals(2, entityCollection.size());
//
//
//    }
//
//    @Test
//    public void canGetObject(){
//
//        DatabaseService service = Database.createInMemory();
//        Entity<Long, SimpleObject> entityCollection = service.createCollection(SimpleObject.class);
//
//        SimpleObject object = new SimpleObject(0L, "Rowan");
//        entityCollection.insert(object);
//        assertEquals(1, entityCollection.size();
//
//        SimpleObject entity = entityCollection.get(object.id);
//        assertEquals(object, entity);
//    }
//
//    @Test
//    public void canClearEntityCollection(){
//        DatabaseService service = Database.createInMemory();
//        Entity<Long, SimpleObject> entityCollection = service.createCollection(SimpleObject.class);
//
//        SimpleObject object = new SimpleObject(0L, "Rowan");
////        entityCollection.insert(object);
//        assertEquals(1, entityCollection.size());
//
//        entityCollection.clear();
//        assertEquals(0, entityCollection.size());
//
//    }

}
