package com.chattech.coherence.serialization;

import java.lang.ref.ReferenceQueue;

/**
 * a cache of interned values in the cluster.
 */
public class InternCache<V> {

    private ReferenceQueue<V> referenceQueue = new ReferenceQueue<V>();
    public void intern(){

    }

}
