package com.testbed.sorting;


//procedure bubbleSort( A : list of sortable items )
//   repeat
//     swapped = false
//     for i = 1 to length(A) - 1 inclusive do:
//       /* if this pair is out of order */
//       if A[i-1] > A[i] then
//         /* swap them and remember something changed */
//         swap( A[i-1], A[i] )
//         swapped = true
//       end if
//     end for
//   until not swapped
//end procedure

import java.util.Arrays;
import java.util.Collection;

/*
================================
Worst case performance O(n^2)
Best case performance  O(n)
Average case performance O(n^2)
--------------------------------
*/

public class BubbleSort extends AbstractSortable {

    public BubbleSort(Collection<? extends Comparable> collection) {
        super(collection);
    }

    Comparable[] bubbleSort(Comparable[] array) {
        boolean swapped;
        do{
            swapped = false;

            for (int i = 1; i < array.length; i++) {
                if (array[i - 1].compareTo(array[i]) == 1) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped);

        return array;
    }

    public Collection<? extends Comparable> sort() {
        return Arrays.asList(bubbleSort(collection.toArray(new Comparable[collection.size()])));
    }
}
