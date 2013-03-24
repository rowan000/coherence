package com.chattech.coherence.domain;

import com.chattech.coherence.serialization.ObjectSerializer;
import com.tangosol.util.ExternalizableHelper;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Controls serialization implementation for Property objects
 */
public class PropertyInternSerializer implements ObjectSerializer<Property> {

    private static PropertyInternSerializer INSTANCE = new PropertyInternSerializer();

    private PropertyInternSerializer(){}


    public static PropertyInternSerializer getInstance() {
        return INSTANCE;
    }

    public void serialize(DataOutput dataOutput, Property property) throws IOException {
        ExternalizableHelper.writeInt(dataOutput, property.getNamespaceId());
        ExternalizableHelper.writeSafeUTF(dataOutput, property.getName());
        ExternalizableHelper.writeSafeUTF(dataOutput, property.getPostCode());
        ExternalizableHelper.writeSafeUTF(dataOutput, property.getCounty());
        ExternalizableHelper.writeSafeUTF(dataOutput, property.getCountry());

    }
    public Property deserialize(DataInput dataInput) throws IOException {

        int namespaceId = ExternalizableHelper.readInt(dataInput);
        String name = ExternalizableHelper.readSafeUTF(dataInput);
        String postCode = ExternalizableHelper.readSafeUTF(dataInput);
        String county = ExternalizableHelper.readSafeUTF(dataInput);
        String country = ExternalizableHelper.readSafeUTF(dataInput);

        return new Property(namespaceId, name, postCode, county, country);

    }
}
