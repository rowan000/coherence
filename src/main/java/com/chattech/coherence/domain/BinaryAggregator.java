package com.chattech.coherence.domain;

import com.tangosol.io.nio.BinaryMap;
import com.tangosol.util.Binary;
import com.tangosol.util.BinaryEntry;
import com.tangosol.util.ExternalizableHelper;
import com.tangosol.util.InvocableMap;

import java.util.*;

/**
 * Aggregate backing map binaries for use in taking snapshots
 */
public class BinaryAggregator implements InvocableMap.ParallelAwareAggregator {

    private Set<PartitionBinaryEntry> binaries = new HashSet<PartitionBinaryEntry>();

    @Override
    public InvocableMap.EntryAggregator getParallelAggregator() {
        return this;
    }

    @Override
    public Object aggregateResults(Collection collection) {
        for(Iterator it = collection.iterator(); it.hasNext();){
            Collection subCollection = (Collection) it.next();
            binaries.addAll(subCollection);
        }

        return binaries;
    }

    @Override
    public Object aggregate(Set set) {
        Set<PartitionBinaryEntry> binaries = new HashSet<PartitionBinaryEntry>();

        Set<BinaryEntry> binaryEntries = (Set<BinaryEntry>) set;
        for(BinaryEntry binaryEntry : binaryEntries){
            int partition = ExternalizableHelper.extractIntDecoration(binaryEntry.getBinaryKey());
            binaries.add(new PartitionBinaryEntry(partition, binaryEntry.getBinaryKey(), binaryEntry.getBinaryValue()));

        }
        return binaries;

    }
}
