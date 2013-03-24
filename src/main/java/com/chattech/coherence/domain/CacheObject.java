package com.chattech.coherence.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 12/11/2012
 * Time: 07:40
 * To change this template use File | Settings | File Templates.
 */
public interface CacheObject<K extends Serializable> {

    K getKey();

}
