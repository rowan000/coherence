package com.chattech.memory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 02/12/2012
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class NumberTranslationParser {

    private static final String translationTag = "translation";
    private static final String translationNumberAttribute = "number";
    private static final String translationNameAttribute = "name";
    private static final String translationCharactersTag = "characters";
    private static final String translationPersonTag = "person";
    private static final String translationActionTag = "action";

    public static Map<Integer, NumberTranslation> parse(String translationFilePath) {

        Map<Integer, NumberTranslation> translations = new HashMap<Integer, NumberTranslation>();
        InputStream stream = NumberTranslationParser.class.getClassLoader().getResourceAsStream(translationFilePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(stream);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        NodeList list = document.getElementsByTagName(translationTag);
        int length = list.getLength();

        for (int i = 0; i < length; i++) {
            Node translationNode = list.item(i);
            NamedNodeMap attributeMap = translationNode.getAttributes();

            Node numberAttributeNode = attributeMap.getNamedItem(translationNumberAttribute);
            int number = Integer.parseInt(numberAttributeNode.getNodeValue());


            Node charactorsAttributeNode = attributeMap.getNamedItem(translationCharactersTag);
            String charactors = charactorsAttributeNode.getNodeValue();

            Node personAttributeNode = attributeMap.getNamedItem(translationPersonTag);
            String person = personAttributeNode.getNodeValue();

            Node actionAttributeNode = attributeMap.getNamedItem(translationActionTag);
            String action = actionAttributeNode.getNodeValue();

            translations.put(number, new NumberTranslation(number, charactors.toCharArray(), person, action));


        }

        return translations;
    }
}
