package com.chattech.memory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NumericTranslationTests{


    @Test
    public void testNumberTranslationInitialisation(){

        NumberTranslater translator = new NumberTranslater();
        assertTrue(translator.getNumberOfTranslations() > 1);
    }

    @Test
    public void testNumberTranslation(){

        NumberTranslater translator = new NumberTranslater();
        NumberTranslation translation = translator.translate(01);

        assertEquals("oi", translation.getCharactors());
        assertEquals("Poirot", translation.getPerson());
        assertEquals("Oiling", translation.getAction());
    }
}
