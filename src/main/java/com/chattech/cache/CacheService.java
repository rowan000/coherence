package com.chattech.cache;

import com.chattech.distribution.udp.server.CacheServer;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 13/01/2013
 * Time: 20:54
 * Distributed cache project
 * Simple api
 * run a cluster
 * get and put into remote caches
 */
public class CacheService {


    public static void start(){
        CacheServer.start();
    }
}
