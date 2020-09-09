/*
Program written by Nick Stantzos on 9/9/2020.
This program uses three different objects to create a collection of 2 million random integers between zero and the
integer size limit.  A separate RNG method will create and return the random number. Three methods will add these
random numbers, then remove these random numbers from an array list, a linked list, and a hash table, respectively. The
total runtime for each process is calculated and displayed in the console after the respective method finishes.
 */

package com.company;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        // Define object size cap as a constant
        int ARRAY_CAP = 2000000;

        // Variable used for tracking how long each method runs for
        long elapsedTime = 0l;

        // Call the array list method and print the runtime
        elapsedTime = RandomArrayList(ARRAY_CAP);
        System.out.println("Total run time for the ArrayList was " + elapsedTime/1000 + " seconds.");

        // Call the linked list method and print the runtime in ms
        elapsedTime = RandomLinkedList(ARRAY_CAP);
        System.out.println("Total run time for the LinkedList was " + elapsedTime + " milliseconds.");

        // Call the hash table method and print the runtime in ms
        elapsedTime = RandomHashTable(ARRAY_CAP);
        System.out.println("Total run time for the HashTable was " + elapsedTime + " milliseconds.");
    }

    /**
     * Method for generating a random number.
     * @return Random integer between 0 and the integer max value
     */
    public static int RNG()
    {
        // Create new random object
        Random rand = new Random();

        // Set upper bound for number generation
        int upperbound = Integer.MAX_VALUE;

        // Return the random number
        return rand.nextInt(upperbound);

    }

    /**
     * Method for populating and deleting elements in an array list
     * @param ARRAY_CAP Array size cap
     * @return Elapsed runtime of populating and removing elements
     */
    public static long RandomArrayList(int ARRAY_CAP)
    {
        // Starting time
        long startTime = System.currentTimeMillis();

        // Array list of integers
        ArrayList<Integer> randomArrayList = new ArrayList();

        // Populate the array list using a for loop and a call to the RNG method
        for(int i = 0; i < ARRAY_CAP; i++)
        {
            randomArrayList.add(RNG());
        }

        // Remove elements of the array using the built in ArrayList.remove() method
        for(int i = 0; i < ARRAY_CAP; i++)
        {
            randomArrayList.remove(0);
        }

        // Calculate and return the runtime
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Method for populating and deleting elements in a linked list
     * @param ARRAY_CAP Linked list size cap
     * @return Elapsed runtime of populating and removing elements
     */
    public static long RandomLinkedList(int ARRAY_CAP)
    {
        // Starting time
        long startTime = System.currentTimeMillis();

        // Linked list of integers
        LinkedList<Integer> randomLinkedList = new LinkedList<>();

        // Populate the linked list using a for loop and a call to the RNG method
        for(int i = 0; i < ARRAY_CAP; i++)
        {
            randomLinkedList.add(RNG());
        }

        // Remove elements of the linked list using the built in LinkedList.remove() method
        for(int i = 0; i < ARRAY_CAP; i++)
        {
            randomLinkedList.remove(0);
        }

        // Calculate and return the runtime
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Method for populating and deleting elements in a hash table
     * @param ARRAY_CAP Hash table size cap
     * @return Elapsed runtime of populating and removing elements
     */
    public static long RandomHashTable(int ARRAY_CAP)
    {
        // Starting time
        long startTime = System.currentTimeMillis();

        // Linked list of integers
        Hashtable<Integer,Integer> randomHashTable = new Hashtable();

        // Populate the hash table using a for loop and a call to the RNG method
        for(int i = 0; i < ARRAY_CAP; i++)
        {
            randomHashTable.put(i,RNG());
        }

        // Remove elements of the hash table using the built in hashtable.remove() method
        for(int i = 0; i < ARRAY_CAP; i++)
        {
            randomHashTable.remove(i);
        }

        // Calculate and return the runtime
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
