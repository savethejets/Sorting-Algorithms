package com.testbed.sorting;

import java.util.Collection;

public abstract class AbstractSortable implements Sortable {

    protected Collection<? extends Comparable> collection;

    public AbstractSortable(Collection<? extends Comparable> collection) {
        this.collection = collection;
    }

    int swap(Comparable[] array, int index1, int index2) {
        Comparable temp = array[index1];

        array[index1] = array[index2];
        array[index2] = temp;

        return index2;
    }

}
