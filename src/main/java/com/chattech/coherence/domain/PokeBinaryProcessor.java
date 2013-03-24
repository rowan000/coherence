package com.chattech.coherence.domain;

import apple.laf.JRSUIConstants;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.Binary;
import com.tangosol.util.BinaryEntry;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Entry processor that updates the entries.
 * This is designed to run per partition.
 */
public class PokeBinaryProcessor extends AbstractProcessor implements PortableObject {

    /**
     * the bytes for the binary value
     */
    private Set<PartitionBinaryEntry> binaries;

    /**
     * The POF index for the WorkAddress property
     */
    public static final int BINARY_MAP_INDEX = 0;


    public PokeBinaryProcessor(Set<PartitionBinaryEntry> binaries) {
        this.binaries = binaries;
    }

    @Override
    public Object process(InvocableMap.Entry canaryEntry) {
        BinaryEntry binaryCanaryEntry = (BinaryEntry) canaryEntry;

        for (PartitionBinaryEntry entry : binaries) {
            BinaryEntry newEntryForBinary = (BinaryEntry) binaryCanaryEntry.getBackingMapContext().getBackingMapEntry(entry.getBinaryKey());

            newEntryForBinary.updateBinaryValue(entry.getBinaryValue());

        }

        return null;
    }


    @Override
    public void readExternal(PofReader reader)
            throws IOException {
        binaries = (Set<PartitionBinaryEntry>) reader.readCollection(BINARY_MAP_INDEX, new HashSet());
    }

    @Override
    public void writeExternal(PofWriter writer)
            throws IOException {
        writer.writeCollection(BINARY_MAP_INDEX, binaries);
    }


}
