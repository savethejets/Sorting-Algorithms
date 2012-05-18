package com.testbed.sorting;

import java.util.Arrays;
import java.util.Collection;


// Top down implementation
public class MergeSort extends AbstractSortable {

    private MergeSortDirection mergeSortDirection;

    public enum MergeSortDirection {
        TOP_DOWN,
        BOTTOM_UP
    }

    public MergeSort(Collection<? extends Comparable> collection, MergeSortDirection mergeSortDirection) {
        super(collection);
        this.mergeSortDirection = mergeSortDirection;
    }

//    function merge_sort(list m)
//    // if list size is 1, consider it sorted and return it
//    if length(m) <= 1
//        return m
//    // else list size is > 1, so split the list into two sublists
//    var list left, right
//    var integer middle = length(m) / 2
//    for each x in m before middle
//         add x to left
//    for each x in m after or equal middle
//         add x to right
//
//    // recursively call merge_sort() to further split each sublist
//    // until sublist size is 1
//    left = merge_sort(left)
//    right = merge_sort(right)
//    // topDownMerge the sublists returned from prior calls to merge_sort()
//    // and return the resulting merged sublist
//    return topDownMerge(left, right)
    Comparable[] topDownMergeSort(Comparable[] array) {
        if (array.length <= 1) {
            return array;
        }

        int halfOfArrayLength = array.length / 2;

        Comparable[] leftArray = new Comparable[halfOfArrayLength];
        Comparable[] rightArray = new Comparable[array.length - halfOfArrayLength];

        int middle = halfOfArrayLength;

        int j = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < middle) {
                leftArray[j++] = array[i];
            } else {
                rightArray[k++] = array[i];
            }
        }

        leftArray = topDownMergeSort(leftArray);
        rightArray = topDownMergeSort(rightArray);

        return topDownMerge(leftArray, rightArray);
    }


    //    function topDownMerge(left, right)
//    var list result
//    while length(left) > 0 or length(right) > 0
//        if length(left) > 0 and length(right) > 0
//            if first(left) <= first(right)
//                append first(left) to result
//                left = rest(left)
//            else
//                append first(right) to result
//                right = rest(right)
//        else if length(left) > 0
//            append first(left) to result
//            left = rest(left)
//        else if length(right) > 0
//            append first(right) to result
//            right = rest(right)
//    end while
//    return result
    Comparable[] topDownMerge(Comparable[] leftArray, Comparable[] rightArray) {
        Comparable[] mergedArray = new Comparable[leftArray.length + rightArray.length];

        int leftIndex = 0;
        int rightIndex = 0;

        int mergedCounter = 0;

        while (leftIndex < leftArray.length || rightIndex < rightArray.length) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 1) {
                    mergedArray[mergedCounter] = leftArray[leftIndex];
                    mergedCounter++;
                    leftIndex++;
                } else {
                    mergedArray[mergedCounter] = rightArray[rightIndex];
                    mergedCounter++;
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                mergedArray[mergedCounter] = leftArray[leftIndex];
                mergedCounter++;
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                mergedArray[mergedCounter] = rightArray[rightIndex];
                mergedCounter++;
                rightIndex++;
            }
        }

        return mergedArray;
    }


//    /* array A[] has the items to sort; array B[] is a work array */

//BottomUpSort(int n, array A[n], array B[n])
//{
//  int width;
//
//  /* each 1-element run in A is already "sorted". */
//
//  /* Make successively longer sorted runs of length 2, 4, 8, 16... until whole array is sorted */
//  for (width = 1; width < n; width = 2 * width)
//    {
//      int i;
//
//      /* array A is full of runs of length width */
//      for (i = 0; i < n; i = i + 2 * width)
//        {
//          /* merge two runs: A[i:i+width-1] and A[i+width:i+2*width-1] to B[] */
//          /*  or copy A[i:n-1] to B[] ( if(i+width >= n) ) */
//          BottomUpMerge(A, i, min(i+width, n), min(i+2*width, n), B);
//        }
//
//      /* now work array B is full of runs of length 2*width */
//      /* copy array B to array A for next iteration */
//      /*   a more efficient implementation would swap the roles of A and B */
//      CopyArray(A, B, n);
//      /* now array A is full of runs of length 2*width */
//    }
//}

//    Comparable[] bottomUpSort(int n, Comparable[] left, Comparable[] right) {
//
//    }

    public Collection<? extends Comparable> sort() {

        Comparable[] result = null;

        if (MergeSortDirection.TOP_DOWN.equals(mergeSortDirection)) {
            result = topDownMergeSort(collection.toArray(new Comparable[collection.size()]));
        } else {
            throw new RuntimeException("Merge Sort Direction not implemented yet");
        }

        return Arrays.asList(result);
    }
}
