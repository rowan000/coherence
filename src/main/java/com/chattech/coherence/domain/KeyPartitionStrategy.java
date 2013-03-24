package com.chattech.coherence.domain;

import com.tangosol.net.PartitionedService;
import com.tangosol.net.partition.KeyPartitioningStrategy;
import com.tangosol.net.partition.PartitionSet;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/11/2012
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class KeyPartitionStrategy implements KeyPartitioningStrategy {

    private PartitionedService partitionedService;
    @Override
    public void init(PartitionedService partitionedService) {
        this.partitionedService = partitionedService;
    }

    @Override
    public int getKeyPartition(Object o) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PartitionSet getAssociatedPartitions(Object o) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
