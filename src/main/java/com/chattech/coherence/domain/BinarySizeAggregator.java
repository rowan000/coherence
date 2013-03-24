package com.chattech.coherence.domain;


import com.tangosol.util.BinaryEntry;
import com.tangosol.util.ExternalizableHelper;
import com.tangosol.util.InvocableMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BinarySizeAggregator implements InvocableMap.ParallelAwareAggregator {

    private long totalSize;

    private boolean includeKeySize = true;

    public BinarySizeAggregator(boolean includeKeySize){
        this.includeKeySize = includeKeySize;
    }

    @Override
    public InvocableMap.EntryAggregator getParallelAggregator() {
        return this;
    }

    @Override
    public Object aggregateResults(Collection collection) {
        for(Iterator it = collection.iterator(); it.hasNext();){
            Long size = (Long) it.next();
            totalSize +=size;
        }

        return totalSize;
    }

    @Override
    public Object aggregate(Set set) {
        long keySize = 0;
        long valueSize = 0;

        Set<BinaryEntry> binaryEntries = (Set<BinaryEntry>) set;
        for(BinaryEntry binaryEntry : binaryEntries){
            keySize += binaryEntry.getBinaryKey().length();
            valueSize += binaryEntry.getBinaryValue().length();
        }

        if(includeKeySize){
            return valueSize + keySize;
        }
        return valueSize;

    }

}
