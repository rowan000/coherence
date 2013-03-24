package com.chattech.algorithms.tsp;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 23/02/2013
 * Time: 09:35
 * To change this template use File | Settings | File Templates.
 */
public class MovieScheduler {

    private List<Movie> movies;

    public MovieScheduler(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> optimal(){
        //pick the movie that finished first
        //delete all movies that clash with this

        List<Movie> sortedCopy = sortedByEndDayCopy();
        return getMovies(sortedCopy);
    }



    public List<Movie> nearestFirst() {
        //nearest first algorithm - sub optimal

        List<Movie> sortedCopy = sortedNearestFirstCopy();
        return getMovies(sortedCopy);
    }

    public List<Movie> shortestFirst() {
        //shortest first algorithm - sub optimal

        List<Movie> sortedCopy = sortedShortestFirstCopy();
        return getMovies(sortedCopy);
    }

    private List<Movie> getMovies(List<Movie> sortedCopy) {
        List<Movie> scheduled = Lists.newArrayList();
        Movie lastMovie = null;
        for(Movie movie : sortedCopy){
            if(lastMovie == null){
                scheduled.add(movie);
                lastMovie = movie;
            } else{
                if(!lastMovie.clashes(movie)){
                    scheduled.add(movie);
                    lastMovie = movie;
                }
            }
        }
        return scheduled;
    }

    private List<Movie> sortedByEndDayCopy() {
        List<Movie> sortedEndDate = Lists.newArrayList(movies);
        Collections.sort(sortedEndDate, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie, Movie movie2) {
                if (movie.getEndDay() < movie2.getEndDay()) {
                    return -11;
                }
                if (movie.getEndDay() > movie2.getEndDay()) {
                    return 1;
                }
                if (movie.getEndDay() == movie2.getEndDay()) {
                    return 0;
                }
                return 0;
            }
        });

        return sortedEndDate;
    }

    private List<Movie> sortedNearestFirstCopy() {
        List<Movie> sortedNearestFirst = Lists.newArrayList(movies);
        Collections.sort(sortedNearestFirst, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie, Movie movie2) {
                if (movie.getStartDay() < movie2.getStartDay()) {
                    return -11;
                }
                if (movie.getStartDay() > movie2.getStartDay()) {
                    return 1;
                }
                if (movie.getStartDay() == movie2.getStartDay()) {
                    return 0;
                }
                return 0;
            }
        });

        return sortedNearestFirst;
    }

    private List<Movie> sortedShortestFirstCopy() {
        List<Movie> sortedNearestFirst = Lists.newArrayList(movies);
        Collections.sort(sortedNearestFirst, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie, Movie movie2) {
                if (movie.getTotalDuration() < movie2.getTotalDuration()) {
                    return -11;
                }
                if (movie.getTotalDuration() > movie2.getTotalDuration()) {
                    return 1;
                }
                if (movie.getTotalDuration() == movie2.getTotalDuration()) {
                    return 0;
                }
                return 0;
            }
        });

        return sortedNearestFirst;
    }


}
