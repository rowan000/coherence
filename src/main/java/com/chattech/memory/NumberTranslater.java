package com.chattech.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 02/12/2012
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class NumberTranslater {

    Map<Integer, NumberTranslation> translations = new HashMap<Integer, NumberTranslation>();

    public NumberTranslater() {
        initialiseTranslations();
    }

    public NumberTranslation translate(int number) {

        NumberTranslation translation = translations.get(number);
        if (translation == null) {
            throw new IllegalArgumentException("No translation exists for number: " + number);
        }
        return translation;

    }


    private void initialiseTranslations() {

        translations = NumberTranslationParser.parse("translations.xml");
    }

    public int getNumberOfTranslations() {
        return translations.size();
    }
}
