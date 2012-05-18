package com.testbed.sorting;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
================================
Worst case performance O(n log n)
Best case performance  O(n log n)
Average case performance O(n ^ 2)
--------------------------------
*/

//   function partition(array, 'left', 'right', 'pivotIndex')
//      'pivotValue' := array['pivotIndex']
//      swap array['pivotIndex'] and array['right']  // Move pivot to end
//      'storeIndex' := 'left'
//      for 'i' from 'left' to 'right' - 1  // left ? i < right
//          if array['i'] < 'pivotValue'
//              swap array['i'] and array['storeIndex']
//              'storeIndex' := 'storeIndex' + 1
//      swap array['storeIndex'] and array['right']  // Move pivot to its final place
//      return 'storeIndex'

//    function quicksort(array, 'left', 'right')
//
//      // If the list has 2 or more items
//      if 'left' < 'right'
//
//          // See "Choice of pivot" section below for possible choices
//          choose any 'pivotIndex' such that 'left' ? 'pivotIndex' ? 'right'
//
//          // Get lists of bigger and smaller items and final position of pivot
//          'pivotNewIndex' := partition(array, 'left', 'right', 'pivotIndex')
//
//          // Recursively sort elements smaller than the pivot
//          quicksort(array, 'left', 'pivotNewIndex' - 1)
//
//          // Recursively sort elements at least as big as the pivot
//          quicksort(array, 'pivotNewIndex' + 1, 'right')

public class QuickSort extends AbstractSortable {

    public QuickSort(Collection<? extends Comparable> collection) {
        super(collection);
    }


    int partition(Comparable[] array, int left, int right, int pivotIndex) {
        Comparable pivotValue = array[pivotIndex];

        swap(array, pivotIndex, right);

        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i].compareTo(pivotValue) == -1) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }


    Comparable[] quicksort(Comparable[] array, int left, int right) {

        if (left < right) {
            int pivot = choosePivot(array, left, right);

            pivot = partition(array, left, right, pivot);

            quicksort(array, left, pivot - 1);

            quicksort(array, pivot + 1, right);
        }

        return array;
    }

    int choosePivot(Comparable[] array, int left, int right) {

        Comparable leftValue = array[left];
        Comparable rightValue = array[right];

        int middle = (int) (((float) right + (float) left) / 2);

        Comparable middleValue = array[middle];

        int valueToReturn;

        if (returnIndex(left, leftValue, rightValue, middleValue)) {
            return left;
        } else if (returnIndex(right, rightValue, leftValue, middleValue)) {
            return right;
        } else if (returnIndex(middle, middleValue, leftValue, rightValue)) {
            return middle;
        }

        return middle;
    }

    private boolean returnIndex(int left, Comparable valueToCompare, Comparable firstOtherValue, Comparable secondOtherValue) {
        int valueToReturn;

        if ((valueToCompare.compareTo(firstOtherValue) == -1 && valueToCompare.compareTo(secondOtherValue) == 1)
             ||  (valueToCompare.compareTo(firstOtherValue) == 1 && valueToCompare.compareTo(secondOtherValue) == -1)) {
            return true;
        }

        return false;
    }


    public Collection<? extends Comparable> sort() {

        Comparable[] sortedArray = quicksort(collection.toArray(new Comparable[collection.size()]), 0, collection.size() - 1);

        return Arrays.asList(sortedArray);

    }

}
