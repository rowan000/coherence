package com.chattech.memory;

import com.chattech.coherence.utils.RandomIndexGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 02/12/2012
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
public class Scratchpad {

    public static void main(String[] args){

        for(int i = 0; i < 10; i++){
            System.out.println("What is the number for " + RandomIndexGenerator.getRandomNumber(40));
        }
    }
}
