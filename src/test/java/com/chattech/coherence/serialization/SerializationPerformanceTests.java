package com.chattech.coherence.serialization;

import com.chattech.coherence.domain.Property;
import com.chattech.coherence.domain.PropertyDao;
import com.chattech.coherence.fixtures.PropertyFixture;
import com.tangosol.net.NamedCache;
import org.junit.Test;

import java.util.Set;

/**
 * Test interning of values
 */
public class SerializationPerformanceTests {

    @Test
    public void testInternDomain(){
        Set<Property> properties = PropertyFixture.getLargeFixedPropertyFixture(100);

        PropertyDao dao = Property.getClassDao();

        NamedCache cache = dao.getCache();

        dao.saveAll(properties);

        long binarySize = dao.aggregateBinarySize();

        System.out.println("POF binary size: " + binarySize + "bytes");

        //push in with serialization

        //push in with standard extern

        //push in with pof

        //push in with intern

        //get sizes and record stats. No assertions in this test
    }
}
