package com.chattech.coherence.utils;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/11/2012
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class RandomIndexGenerator {

    public static int getRandomNumber(int max){
        double random = Math.random();
        int randomInt = new Double(random * 100).intValue() % max;

        return randomInt;
    }
}
