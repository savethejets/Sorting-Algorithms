package com.testbed.sorting;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.*;

public class HeapSortTest extends TestCase {

    public void testSort() throws Exception {

        Integer[] list = {1, 33, 5, 40, 2, 6, 7, 8, 11, 15, 17, 66, 26, 52, 41, 88, 93, 16, 74, 33, 90, 14};

        HeapSort heapSort = new HeapSort(Arrays.asList(list));

        Collection<? extends Comparable> sortedList = heapSort.sort();

        for (int i = 0; i < sortedList.size() - 1; i++) {
            Integer integer = (Integer) sortedList.toArray()[i];
            Integer integer2 = (Integer) sortedList.toArray()[i+1];

            Assert.assertTrue(integer + " is not less than " + integer2, integer.compareTo(integer2) < 1);
        }

    }

    public void testStressTest() throws Exception {

        List<Integer> list = new ArrayList<Integer>();


        int maxSize = 10000000;

        System.out.println("Initializing...");

        int i = 0;
        while (i < maxSize) {
            list.add(new Random().nextInt(100000));
            i++;
        }

        HeapSort heapSort = new HeapSort(list);

        System.out.println("Starting sort...");

        Long startTime = System.currentTimeMillis();

        heapSort.sort();

        Long endTime = System.currentTimeMillis();

        System.out.println("Sorting took " + ((endTime - startTime) +" milliseconds"));
    }
}
