package com.chattech.coherence.domain;

import com.tangosol.util.Binary;
import com.tangosol.util.BinaryEntry;
import com.tangosol.util.ExternalizableHelper;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

/**
 * Entry processor for extracting the binary for an entry
 */
public class ExtractBinaryProcessor extends AbstractProcessor {

    @Override
    public Object process(InvocableMap.Entry entry) {

        Binary value = null;
        if(entry != null){
            BinaryEntry binaryEntry = (BinaryEntry) entry;
            value = binaryEntry.getBinaryValue();
        }
        return value;
    }
}
