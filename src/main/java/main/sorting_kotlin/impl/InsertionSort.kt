package main.sorting_kotlin.impl

import main.sorting_kotlin.Sort

class InsertionSort : Sort<IntArray> {
    override fun getSorted(table: IntArray): IntArray {
        return (1 until table.size)
                .first { table[it] < table[it - 1] }
                .let { swapAllBetween(table, getLastSmallerIndex(table, it), it) }
    }

    fun getLastSmallerIndex(table: IntArray, index: Int): Int {
        return (index - 1 downTo 0)
                .firstOrNull { table[it] < table[index] }
                ?.let { it + 1 }
                ?: 0
    }

    fun swapAllBetween(table: IntArray, from: Int, to: Int):IntArray {
        var swapped: List<Int> = table.toList().subList(0, from)
        swapped.plus(table[to])
        swapped.plus(table.copyOfRange(from, table.size - 2))
        return swapped.toIntArray()
    }
}
