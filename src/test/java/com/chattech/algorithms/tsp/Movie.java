package com.chattech.algorithms.tsp;

import org.codehaus.jackson.map.ext.JodaDeserializers;
import org.joda.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 23/02/2013
 * Time: 09:08
 * To change this template use File | Settings | File Templates.
 */
public class Movie {

    private String name;
    private int startDay;
    private int endDay;

    public Movie(String name, int startDay, int endDay) {
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public int getTotalDuration(){
        return (endDay - startDay) +1;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public boolean clashes(Movie anotherMovie){
        if(anotherMovie.startDay >= this.startDay && anotherMovie.startDay <= this.endDay){
            return true;
        }
        if(this.startDay >= anotherMovie.startDay && this.startDay <= anotherMovie.endDay){
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                '}';
    }
}
