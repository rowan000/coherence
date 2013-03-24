package com.chattech.coherence.domain;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.Binary;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 14/11/2012
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
public class PartitionBinaryEntry implements PortableObject {

    private int partition;
    private Binary binaryKey;
    private Binary binaryValue;

    public static final int PARTITION_INDEX = 0;
    public static final int BINARY_KEY_INDEX = 1;
    public static final int BINARY_VALUE_INDEX = 2;

    public PartitionBinaryEntry() {
    }

    public PartitionBinaryEntry(int partition, Binary binaryKey, Binary binaryValue) {
        this.partition = partition;
        this.binaryKey = binaryKey;
        this.binaryValue = binaryValue;
    }

    public int getPartition() {
        return partition;
    }

    public Binary getBinaryKey() {
        return binaryKey;
    }

    public Binary getBinaryValue() {
        return binaryValue;
    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {
        this.partition = pofReader.readInt(PARTITION_INDEX);
        this.binaryKey = pofReader.readBinary(BINARY_KEY_INDEX);
        this.binaryValue = pofReader.readBinary(BINARY_VALUE_INDEX);
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeInt(PARTITION_INDEX, partition);
        pofWriter.writeBinary(BINARY_KEY_INDEX, binaryKey);
        pofWriter.writeBinary(BINARY_VALUE_INDEX, binaryValue);
    }
}
