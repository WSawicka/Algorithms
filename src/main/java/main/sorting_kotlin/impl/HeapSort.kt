package main.sorting_kotlin.impl

import main.sorting_kotlin.Sort

class HeapSort : Sort<IntArray> {
    override fun getSorted(table: IntArray): IntArray {
        for (i in table.size / 2 - 1 downTo  0) {
            heapify(table, i, table.size)
        }
        for (i in table.size - 1 downTo 0) {
            swap(table, 0, i)
            heapify(table, 0, i)
        }
        return table
    }

    fun heapify(table: IntArray, i: Int, n: Int){
        var max = i

        if (left(i) < n && table[left(i)] > table[max]) {
            max = left(i)
        }
        if (right(i) < n && table[right(i)] > table[max]) {
            max = right(i)
        }
        if (max != i) {
            swap(table, max, i)
            heapify(table, max, n)
        }
    }

    fun left(i: Int): Int {
        return 2 * i + 1
    }

    fun right(i: Int): Int {
        return 2 * i + 2
    }

    fun swap(table: IntArray, a: Int, b: Int) {
        val temp = table[a]
        table[a] = table[b]
        table[b] = temp
    }
}
