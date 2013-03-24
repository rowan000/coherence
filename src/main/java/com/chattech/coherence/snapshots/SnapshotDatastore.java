package com.chattech.coherence.snapshots;

import com.tangosol.util.Binary;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 12/11/2012
 * Time: 07:56
 * To change this template use File | Settings | File Templates.
 */
public interface SnapshotDatastore {


    void saveBinary(Binary binary);
}
