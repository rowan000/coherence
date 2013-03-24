package com.chattech.coherence.snapshots;

import com.chattech.coherence.domain.PartitionBinaryEntry;
import com.chattech.coherence.domain.Property;
import com.chattech.coherence.domain.PropertyDao;
import com.chattech.coherence.fixtures.PropertyFixture;
import com.tangosol.net.DefaultCacheServer;
import org.junit.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static junit.framework.Assert.*;

/**
 * Investigate whether we can write binaries from partitions to datastore
 * Then prove we can restore these to the cluster without any loss
 */
public class BinarySnapshotTest {


    @BeforeClass
    public static void setup() {
        DefaultCacheServer.start();

    }

    @AfterClass
    public static void teardown() {
        DefaultCacheServer.shutdown();
    }



    @Test
    public void canExtractBinaries() {
        setupFixture();


        PropertyDao dao = getPropertyDao();

        Set<Property> properties = dao.getAll();
        assertEquals(2, properties.size());


        Set<PartitionBinaryEntry> binaries = dao.getBinaries();


        dao.removeAll();

        dao.pokeBinaries(binaries);

        Set<PartitionBinaryEntry> binariesAfterPoke = dao.getBinaries();

        assertPartitionsRemainTheSame(binaries, binariesAfterPoke);

        properties = dao.getAll();
        assertEquals(2, properties.size());


        for(Property property : properties){
            System.out.println("Property from restored Binary: " + property);
        }


    }

    private void assertPartitionsRemainTheSame(Set<PartitionBinaryEntry> binaries, Set<PartitionBinaryEntry> binariesAfterPoke) {
        Map<Integer, Integer> partitionsByHash = new HashMap<Integer, Integer>();
        for(PartitionBinaryEntry binaryEntry : binaries){
            partitionsByHash.put(binaryEntry.getBinaryKey().hashCode(), binaryEntry.getPartition());
        }

        for(PartitionBinaryEntry binaryEntry : binariesAfterPoke){
            int originalPartition = partitionsByHash.get(binaryEntry.getBinaryKey().hashCode());
            assertEquals(originalPartition, binaryEntry.getPartition());
        }
    }


    private PropertyDao getPropertyDao() {
        return Property.getClassDao();
    }

    private void setupFixture() {
        Set<Property> properties = PropertyFixture.getFixedPropertyFixture();
        for(Property property : properties){
            getPropertyDao().save(property);
        }

    }
}
