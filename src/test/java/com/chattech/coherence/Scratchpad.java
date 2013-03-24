package com.chattech.coherence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 20/11/2012
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public class Scratchpad {


    private Map<Long, NamespaceInstance> namespaceInstanceCache = new HashMap<Long, NamespaceInstance>();

    private Map<String, Long> namespaceInstanceIdCache = new HashMap<String, Long>();

    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args){

        //use db namespace id as cluster id - means we lose the ability to reload same ns twice
        //the whole point of NamespaceInstanceId is to map the id string to a cluster instance

        //namespace id slurper could be used in the same way session id's are managed
        //cluster id slurper still leaves us with a problem
        //this gains us, knowledge of the db id in the cluster


        Scratchpad pad = new Scratchpad();


        int dbId = 1;
        String name = "EOD";
        Map<String, String> identity = new HashMap<String, String>();


        //ns id in db is controlled by sequence with unique contraint on name/identity attributes (I think)

        //snapping the NamespaceIntanceId get's around this problem.
        //but if we want to restore a snap from one environment to another, we are likely to get id clashes
        //in fact, we will get id clashes even in the cluster restart scenario.
        //i.e. snaps restoring, sink messages from qr create a new id from the reset counter, a snap will conflict.
        //a database sequence would get around this problem. However this would still break if we were to restore a snap from another environment
        //as the db sequence id would not be unique across db's

        //so either we use the slurper and make things work with normal restore
        //or come up with a better solution that works for all

        //db solution would mean we store the nsdb id in the namespaceinstance
        //the lookup could query by dbid instead, this would return multiple namespace instances.

        //how about the NamespaceInstanceId hold string --> dbid

        //then we have another mapping from dbId --> clusterId

        //how would the slurper work with two sinks? db and coh sink

        //flawed, as this will create a new ns id different to the snap


        //adding the index results in a deserialization for each put!
        //run something similar with trr - which has pof key and entry defined in pof config to
        //build sequence diagram of calls




        String nsName = "EOD";


        int clusterId = pad.ensureBasedOnCounter(nsName, new HashMap<String, String>());

        //apply snap for id 1;

        NamespaceInstance snappedInstance = new NamespaceInstance();

        pad.applySnap(clusterId, snappedInstance);

        //queue receiver

        int nsId = pad.ensureBasedOnCounter("EOD", new HashMap());

        assertTrue("Snapped cluster id is not the same as the ensured - ensured: " + nsId + " snapped: " + clusterId, nsId == clusterId);


    }

    private void applySnap(long snappedInstanceId, NamespaceInstance snappedInstance) {

        namespaceInstanceCache.put(snappedInstanceId, snappedInstance);
    }

    private int ensureBasedOnCounter(String name, Map<String, String> identity) {

        Long clusterId = namespaceInstanceIdCache.get(name);
        if(clusterId == null){
            return counter.incrementAndGet();
        } else {
            return clusterId.intValue();
        }
    }
}
