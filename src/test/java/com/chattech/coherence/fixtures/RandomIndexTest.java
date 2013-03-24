package com.chattech.coherence.fixtures;

import com.chattech.coherence.utils.RandomIndexGenerator;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/11/2012
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class RandomIndexTest {

    @Test
    public void testRandomIndex(){

        for(int i= 0; i< 1000; i++){
            int max = 10;
            int index = RandomIndexGenerator.getRandomNumber(max);
            assertTrue("Index should be less than " + max + " and >= " + 0 + " but is " + index, index <= 10 && index >= 0);
        }

    }
}
