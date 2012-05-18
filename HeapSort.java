package com.testbed.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


/**
 * Psuedo-code
 */

/*
    function heapSort(a, count) is
    input:  an unordered array a of length count

    (first place a in max-heap order)
    heapify(a, count)

    end := count-1 //in languages with zero-based arrays the children are 2*i+1 and 2*i+2
    while end > 0 do
    (swap the root(maximum value) of the heap with the last element of the heap)
    swap(a[end], a[0])
    (decrease the size of the heap by one so that the previous max value will
    stay in its proper placement)
    end := end - 1
    (put the heap back in max-heap order)
    siftDown(a, 0, end)

    function heapify(a, count) is
    (start is assigned the index in a of the last parent node)
    start := (count - 2) / 2

    while start ? 0 do
    (sift down the node at index start to the proper place such that all nodes below
    the start index are in heap order)
    siftDown(a, start, count-1)
    start := start - 1
    (after sifting down the root all nodes/elements are in heap order)

    function siftDown(a, start, end) is
    input:  end represents the limit of how far down the heap
          to sift.
    root := start

    while root * 2 + 1 ? end do          (While the root has at least one child)
    child := root * 2 + 1        (root*2 + 1 points to the left child)
    swap := root        (keeps track of child to swap with)
    (check if root is smaller than left child)
    if a[swap] < a[child]
    swap := child
    (check if right child exists, and if it's bigger than what we're currently swapping with)
    if child+1 ? end and a[swap] < a[child+1]
    swap := child + 1
    (check if we need to swap at all)
    if swap != root
    swap(a[root], a[swap])
    root := swap          (repeat to continue sifting down the child now)
    else
    return
*/

/*
================================
Worst case performance O(n log n)
Best case performance  O(n log n)
Average case performance O(n log n)
--------------------------------
*/

public class HeapSort extends AbstractSortable {

    public HeapSort(Collection<? extends Comparable> collection) {
        super(collection);
    }

    Comparable[] heapify(Comparable[] array, int count) {
        int start = (count - 2) / 2;

        while (start >= 0) {
            siftDown(array, start, count - 1);
            start = start - 1;
        }

        return array;
    }

    Comparable[] siftDown(Comparable[] array, int start, int end) {
        int root = start;

        while (root * 2 + 1 <= end) {
            int child = root * 2 + 1;
            int swap = root;

            if (array[swap].compareTo(array[child]) == -1) {
                swap = child;
            }

            if (child + 1 <= end && array[swap].compareTo(array[child + 1]) == -1) {
                swap = child + 1;
            }

            if (swap != root) {
                root = swap(array, root, swap);
            } else {
                return array;
            }
        }

        return array;
    }

    public Collection<? extends Comparable> sort() {
        int count = collection.size();

        Comparable[] array = heapify(collection.toArray(new Comparable[count]), count);

        int end = count - 1;

        while (end > 0) {
            swap(array, end, 0);

            end = end - 1;

            array = siftDown(array, 0, end);
        }

        return Arrays.asList(array);
    }

}
