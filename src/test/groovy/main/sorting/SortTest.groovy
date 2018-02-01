package main.sorting

import main.sorting.impl.*
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class SortTest extends Specification {
    static int[] t1 = [4, 1, 4, 2, 8, 5, 9, 1, 5, 2, 7]
    static int[] t2 = [1, 34, 3, 98, 9, 76, 45, 4]
    static int[] t3 = [45, 8, 5, 123, 46, 92, 4, -12, -45, 88, 63, 75, 55, 74, 93, 65, 58, 12, -3, 0, -8, -9, 8, 23, 88, 45,
                51, 53, 35, 66, 47, 72, 33, 62, -44, 70, 55, 21, 31, -18, -20, 9, 14, -1, -4, 24, 57, 33, 93, 65]
    static int[] t4 = [15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, 10]
    static int[] rand = fillWithRand(5000)

    static int[] fillWithRand(int size) {
        Random random = new Random()
        int[] tab = new int[size]
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(Integer.MAX_VALUE / 4 as int)
        }
        return tab
    }

    def setup() {
        t1 = [4, 1, 4, 2, 8, 5, 9, 1, 5, 2, 7]
        t2 = [1, 34, 3, 98, 9, 76, 45, 4]
        t3 = [45, 8, 5, 123, 46, 92, 4, -12, -45, 88, 63, 75, 55, 74, 93, 65, 58, 12, -3, 0, -8, -9, 8, 23, 88, 45, 51,
              53, 35, 66, 47, 72, 33, 62, -44, 70, 55, 21, 31, -18, -20, 9, 14, -1, -4, 24, 57, 33, 93, 65]
        t4 = [15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, 10]
        rand = fillWithRand(1000)
    }

    @Unroll
    def "bubble sort - check table #name"() {
        expect:
        isSorted(new BubbleSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    def "counting sort - check table #name"() {
        expect:
        isSorted(new CountingSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    def "heap sort - check table #name"() {
        expect:
        isSorted(new HeapSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    def "insertion sort - check table #name"() {
        expect:
        isSorted(new InsertionSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    def "merge sort - check table #name"() {
        expect:
        isSorted(new MergeSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    @Ignore
    def "radix sort - check table #name"() {
        expect:
        isSorted(new RadixSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    def "selection sort - check table #name"() {
        expect:
        isSorted(new SelectionSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    @Unroll
    def "quick sort - check table #name"() {
        expect:
        isSorted(new QuickSort().getSortedData(test))

        where:
        name   | test
        "t1"   | t1
        "t2"   | t2
        "t3"   | t3
        "t4"   | t4
        "rand" | rand
    }

    def isSorted(list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false
            }
        }
        return true
    }
}
