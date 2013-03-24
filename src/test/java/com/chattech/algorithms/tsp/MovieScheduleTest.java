package com.chattech.algorithms.tsp;

import com.google.common.collect.Lists;
import org.junit.Test;

import javax.swing.*;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 23/02/2013
 * Time: 09:05
 * Given a schedule of movies, pick films for an actor to maximise the number of films
 * Each film pays the same
 */
public class MovieScheduleTest {

    @Test
    public void nearestFirst(){

        Movie jaws = new Movie("Jaws", 1, 20);
        Movie scream = new Movie("Scream", 3, 5);
        Movie bladeRunner = new Movie("BladeRUnner", 6, 8);

        //best outcome is scream and bladerunner
        //worst is jaws

        MovieScheduler scheduler = new MovieScheduler(Lists.newArrayList(jaws, scream, bladeRunner));

        List<Movie> movies = scheduler.nearestFirst();

        assertEquals(1, movies.size());
        assertEquals("Jaws", movies.get(0).getName());


        movies = scheduler.optimal();
        assertEquals(2, movies.size());


    }

    @Test
    public void shortestFirst(){

        Movie jaws = new Movie("Jaws", 1, 20);
        Movie scream = new Movie("Scream", 21, 30);
        Movie bladeRunner = new Movie("BladeRunner", 18, 22);

        //best outcome is jaws and scream
        //worst is bladerunner

        MovieScheduler scheduler = new MovieScheduler(Lists.newArrayList(jaws, scream, bladeRunner));

        List<Movie> movies = scheduler.shortestFirst();

        assertEquals(1, movies.size());
        assertEquals("BladeRunner", movies.get(0).getName());
        movies = scheduler.optimal();
        assertEquals(2, movies.size());
    }

    @Test
    public void optimal(){
        Movie rats = new Movie("rats", 1, 3);
        Movie jaws = new Movie("Jaws", 2, 20);
        Movie rats2 = new Movie("rats2", 10, 17);
        Movie jaws2 = new Movie("jaws2", 18, 22);
        Movie jaws3 = new Movie("jaws3", 15, 25);
        Movie jaws4 = new Movie("jaws4", 23, 26);
        Movie bladeRunner = new Movie("BladeRunner", 28, 31);
        Movie scream = new Movie("Scream", 21, 30);



        //best outcome is jaws and scream
        //worst is bladerunner

        MovieScheduler scheduler = new MovieScheduler(Lists.newArrayList(jaws, rats, rats2, jaws2, jaws3, jaws4, scream, bladeRunner));

        List<Movie> movies = scheduler.optimal();
        assertEquals(5, movies.size());
        System.out.println(movies);
    }
}
