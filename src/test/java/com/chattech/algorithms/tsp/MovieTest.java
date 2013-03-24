package com.chattech.algorithms.tsp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 23/02/2013
 * Time: 09:17
 * To change this template use File | Settings | File Templates.
 */
public class MovieTest {


    @Test
    public void movieHasDuration(){
        Movie jaws = new Movie("Jaws", 1, 10);
        assertEquals(10, jaws.getTotalDuration());
    }

    @Test
    public void testClash(){

        Movie jaws = new Movie("Jaws", 1, 10);
        Movie scream = new Movie("Scream", 2, 12);
        Movie bladeRunner = new Movie("Blade Runner", 11, 15);

        assertTrue(jaws.clashes(scream));
        assertTrue(scream.clashes(jaws));
        assertTrue(scream.clashes(bladeRunner));
        assertTrue(bladeRunner.clashes(scream));
        assertFalse(jaws.clashes(bladeRunner));
        assertFalse(bladeRunner.clashes(jaws));
    }
}
