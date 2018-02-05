package main.sorting_kotlin.impl

import main.sorting_kotlin.Sort

class BubbleSort : Sort<IntArray> {

    override fun getSorted(table: IntArray): IntArray {
        for (i in table) {
            var swapped: Boolean = false
            for (index in 0 until table.size - 1) {
                if (table[index] > table[index + 1]) {
                    swap(table, index)
                    swapped = true
                }
            }
            if (!swapped) break
        }
        return table
    }

    private fun swap(table: IntArray, index: Int) {
        val temp: Int = table[index]
        table[index] = table[index + 1]
        table[index + 1] = temp
    }
}
