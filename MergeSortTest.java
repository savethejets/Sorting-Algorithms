package com.testbed.sorting;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collection;

public class MergeSortTest extends TestCase {
    public void testSort() throws Exception {
        Integer[] list = {1, 33, 5, 40, 2, 6, 7, 8, 11, 15, 17, 66, 26, 52, 41, 88, 93, 16, 74, 33, 90, 14};

        MergeSort heapSort = new MergeSort(Arrays.asList(list), MergeSort.MergeSortDirection.TOP_DOWN);

        Collection<? extends Comparable> sortedList = heapSort.sort();

        System.out.println(sortedList);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            Integer integer = (Integer) sortedList.toArray()[i];
            Integer integer2 = (Integer) sortedList.toArray()[i+1];

            Assert.assertTrue(integer + " is not less than " + integer2, integer.compareTo(integer2) < 1);
        }
    }
}
