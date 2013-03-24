package com.chattech.coherence.domain;


import com.chattech.coherence.utils.RandomIndexGenerator;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.net.CacheFactory;

import java.io.IOException;

/**
 * Represents a simple property with name and post code for use
 * in testing coherence
 */
public class Property implements CacheObject<Integer>, PortableObject {

    private int namespaceId;
    private String name;
    private String postCode;
    private String county;
    private String country;

    /**
     * The POF indices
     */
    public static final int NSID_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int POSTCODE_INDEX = 2;
    public static final int COUNTY_INDEX = 3;
    public static final int COUNTRY_INDEX = 4;

    public Property(){}

    public Property(int namespaceId, String name, String postCode, String county, String country) {
        this.namespaceId = namespaceId;
        this.name = name;
        this.postCode = postCode;
        this.county = county;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }

    public int getNamespaceId() {
        return namespaceId;
    }

    @Override
    public Integer getKey() {
        return this.getNamespaceId();
    }

    public static PropertyDao getClassDao() {
        //TODO move into spring
        PropertyDao dao = new PropertyDao();
        return dao;
    }

    @Override
    public String toString() {
        return "Property{" +
                "namespaceId=" + namespaceId +
                ", name='" + name + '\'' +
                ", postCode='" + postCode + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

//    @Override
//    public void readExternal(DataInput dataInput) throws IOException {
//        Property property = PropertyExternSerializer.getInstance().deserialize(dataInput);
//        this.name = property.getName();
//        this.postCode = property.getPostCode();
//        this.county = property.getCounty();
//        this.country = property.getCountry();
//    }
//
//    @Override
//    public void writeExternal(DataOutput dataOutput) throws IOException {
//        PropertyExternSerializer.getInstance().serialize(dataOutput, this);
//    }

    @Override
    public void readExternal(PofReader pofReader) throws IOException {

        //would call to dao, but we'll just pretend

        //this would be in the FoundrySerializerPofAdaptor.deserialise

        //how to avoid doing for normal deserialization?
        //could mark something in hte stream to indicate it's snapped
        //if snapped, then modify namespace, otherwise - all is well
        //book index on trr - currently rob believe it deserializes it to build index.
        //this is inline with behaviour I've seen on the proprety cache.
        //if we stuck book in the pof stream, how would this help us -
        //because currently book is in the entry
        //if we enriched the key, we would only have to derialize the key
        //in the binaryentryupdator we can deserialise the key - this will do that enrichment

        int oldNamespaceId = pofReader.readInt(NSID_INDEX);

        //modify namespaceId

        namespaceId = ensureNamespace();

        System.out.println("Modified namespace id from " + oldNamespaceId + " to " + namespaceId);
        name = pofReader.readString(NAME_INDEX);
        postCode = pofReader.readString(POSTCODE_INDEX);
        county = pofReader.readString(COUNTY_INDEX);
        country = pofReader.readString(COUNTRY_INDEX);
        System.out.println("deserialization of ns: " + namespaceId + " on " + CacheFactory.getCluster().getLocalMember());
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {

        pofWriter.writeInt(NSID_INDEX, namespaceId);
        pofWriter.writeString(NAME_INDEX, name);
        pofWriter.writeString(POSTCODE_INDEX, postCode);
        pofWriter.writeString(COUNTY_INDEX, county);
        pofWriter.writeString(COUNTRY_INDEX, country);
        System.out.println("serialization of ns: " + namespaceId + " on " + CacheFactory.getCluster().getLocalMember());
    }


    private int ensureNamespace(){
        return RandomIndexGenerator.getRandomNumber(10);
    }

}
