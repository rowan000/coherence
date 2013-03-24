package com.chattech.coherence.domain;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.NamedCache;
import com.tangosol.net.PartitionedService;
import com.tangosol.util.Binary;
import com.tangosol.util.BinaryEntry;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;
import com.tangosol.util.filter.AllFilter;
import com.tangosol.util.filter.AlwaysFilter;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Simple dao for reading and writing to the Property named cache
 */
public class PropertyDao {

    private NamedCache cache;
    private volatile boolean initialised = false;

    public PropertyDao(){
        initialiseDao();
    }

    private void initialiseDao(){
        if(initialised == false){

            //obtain the named cache
            cache = CacheFactory.getCache(Property.class.getName());

            //add index
//            ValueExtractor extractor = new ReflectionExtractor("getCounty");
//            cache.addIndex(extractor, false, null);
            initialised = true;
        }
    }
    public void save(Property property){
        cache.put(property.getKey(), property);
    }

    public Property get(String key) {
        return (Property) cache.get(key);
    }


    public Set<PartitionBinaryEntry> getBinaries(){
        Set<PartitionBinaryEntry> binaries = (Set<PartitionBinaryEntry>) cache.aggregate(new AlwaysFilter(), new BinaryAggregator());
        return binaries;
    }

    public long aggregateBinarySize(){
        return (Long) cache.aggregate(new AlwaysFilter(), new BinarySizeAggregator(true));
    }


    public void remove(String key) {
        cache.remove(key);
    }


    public Set<String> getKeys() {
        return cache.keySet();
    }

    public void removeAll() {
        cache.clear();
    }

    public Set<Property> getAll() {
        Set<Property> properties = new HashSet<Property>();
        Collection<Property> entries = cache.values();
        for(Property entry : entries){
            properties.add(entry);
        }
        return properties;
    }

    public void pokeBinaries(Set<PartitionBinaryEntry> binaries) {

        PartitionedService service = (PartitionedService) cache.getCacheService();

        //get canarycache - namedcache

        cache.invoke(1, new PokeBinaryProcessor(binaries));

    }

    public NamedCache getCache() {
        return cache;
    }

    public void saveAll(Set<Property> properties) {
        Map<Integer, Property> propertyMap = new HashMap<Integer, Property>();
        for(Property property : properties){
            propertyMap.put(property.getKey(), property);
        }
        cache.putAll(propertyMap);
    }
}
