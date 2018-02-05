package main.sorting_kotlin.impl

import main.sorting_kotlin.Sort

class MergeSort : Sort<IntArray> {
    override fun getSorted(table: IntArray): IntArray {
        if (table.size == 1) {
            return table
        } else if (table.size == 2) {
            if (table[0] > table[1]) {
                swap(table, 0, 1)
            }
            return table
        } else {
            val left: IntArray = table.copyOfRange(0, table.size / 2)
            val right: IntArray = table.copyOfRange(table.size / 2, table.size)
            return getMerged(getSorted(left), getSorted(right))
        }
    }

    fun getMerged(left: IntArray, right: IntArray): IntArray {
        val merged: IntArray = kotlin.IntArray(left.size + right.size)
        var leftInd: Int = 0
        var rightInd: Int = 0

        while (true) {
            if (left.size > leftInd && right.size > rightInd) {
                if (left[leftInd] < right[rightInd]) {
                    merged.plus(left[leftInd])
                    leftInd++
                } else {
                    merged.plus(right[rightInd])
                    rightInd++
                }
            } else if (left.size <= leftInd) {
                merged.plus(right)
                break
            } else {
                merged.plus(left)
                break
            }
        }
        return merged
    }

    fun swap(table: IntArray, a: Int, b: Int) {
        val temp = table[a]
        table[a] = table[b]
        table[b] = temp
    }
}
