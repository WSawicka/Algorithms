package main.sorting

import main.sorting.impl.*
import spock.lang.Specification

class SortTest extends Specification {
    int[] t1 = [4, 1, 4, 2, 8, 5, 9, 1, 5, 2, 7] //1 1 2 2 4 4 5 5 7 8 9
    int[] t2 = [1, 34, 3, 98, 9, 76, 45, 4]
    int[] t3 = [45, 8, 5, 123, 46, 92, 4, -12, -45, 88, 63, 75, 55, 74, 93, 65, 58, 12, -3, 0, -8, -9, 8, 23, 88, 45, 51, 53, 35, 66, 47, 72, 33, 62,
                -44, 70, 55, 21, 31, -18, -20, 9, 14, -1, -4, 24, 57, 33, 93, 65]
    int[] t4 = [15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, 10]

    def "bubble sort - check if every table is well sorted"() {
        expect:
        isSorted(new BubbleSort().getSortedData(t1))
        isSorted(new BubbleSort().getSortedData(t2))
        isSorted(new BubbleSort().getSortedData(t3))
        isSorted(new BubbleSort().getSortedData(t4))
    }

    def "insertion sort - check if every table is well sorted"() {
        expect:
        isSorted(new InsertionSort().getSortedData(t1))
        isSorted(new InsertionSort().getSortedData(t2))
        isSorted(new InsertionSort().getSortedData(t3))
        isSorted(new InsertionSort().getSortedData(t4))
    }

    def "merge sort - check if every table is well sorted"() {
        expect:
        isSorted(new MergeSort().getSortedData(t1))
        isSorted(new MergeSort().getSortedData(t2))
        isSorted(new MergeSort().getSortedData(t3))
        isSorted(new MergeSort().getSortedData(t4))
    }

    def "selection sort - check if every table is well sorted"() {
        expect:
        isSorted(new SelectionSort().getSortedData(t1))
        isSorted(new SelectionSort().getSortedData(t2))
        isSorted(new SelectionSort().getSortedData(t3))
        isSorted(new SelectionSort().getSortedData(t4))
    }

    def "quick sort - check if every table is well sorted"() {
        expect:
        isSorted(new QuickSort().getSortedData(t1))
        isSorted(new QuickSort().getSortedData(t2))
        isSorted(new QuickSort().getSortedData(t3))
        isSorted(new QuickSort().getSortedData(t4))
    }

    def isSorted(list) {
        list.size() < 2 || (1..<list.size()).every {
            list[it - 1] <= list[it]
        }
    }
}
