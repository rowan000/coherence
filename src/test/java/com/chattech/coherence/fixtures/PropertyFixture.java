package com.chattech.coherence.fixtures;

import com.chattech.coherence.domain.Property;
import com.chattech.coherence.utils.RandomIndexGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 15/11/2012
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class PropertyFixture {

    private static List<String> countries = populateCountries();
    private static List<String> counties = populateCounties();


    private static List<String> populateCountries(){
        countries = new ArrayList<String>();
        countries.add("United Kingdom");
        countries.add("Germany");
        countries.add("France");
        countries.add("United States");
        return countries;
    }

    private static List<String> populateCounties(){
        counties = new ArrayList<String>();
        counties.add("Surrey");
        counties.add("Shropshire");
        counties.add("Berkshire");
        counties.add("StaffordShire");
        return counties;
    }
    public static Set<Property> getFixedPropertyFixture(){
        Property property1 = new Property(1, "Flat 13 Albany Court", "TW20 9GP", "Surrey", "United Kingdom");
        Property property2 = new Property(2, "2 Llanbrook", "SY7 0QG", "Shropshire", "United Kingdom");

        Set<Property> properties = new HashSet<Property>();

        properties.add(property1);
        properties.add(property2);
        return properties;
    }

    public static Set<Property> getLargeFixedPropertyFixture(int numberOfProperties){

        Set<Property> properties = new HashSet<Property>();

        String namePrefix = "Flat ";
        String postCodePrefix = "TW20 9GP";

        for(int i = 0; i < numberOfProperties; i++){
            String country = getRandomCountry();
            String county = getRandomCounty();
            properties.add(new Property(i, namePrefix + i, postCodePrefix + i, county, country));
        }

        return properties;
    }

    private static String getRandomCounty() {
        return counties.get(RandomIndexGenerator.getRandomNumber(counties.size()));
    }

    private static String getRandomCountry() {
        return countries.get(RandomIndexGenerator.getRandomNumber(countries.size()));
    }


}
