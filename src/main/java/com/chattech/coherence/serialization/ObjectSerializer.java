package com.chattech.coherence.serialization;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public interface ObjectSerializer<V> {

    void serialize(DataOutput dataOutput, V property) throws IOException;
    V deserialize(DataInput dataInput) throws IOException;


}
