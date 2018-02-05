package main.sorting_kotlin.impl

import main.sorting_kotlin.Sort

class CountingSort : Sort<IntArray> {
    override fun getSorted(table: IntArray): IntArray {
        var minVal: Int = table[0]
        var maxVal: Int = table[0]

        for (item in table) {
            if (item < minVal) {
                minVal = item
            } else if (item > maxVal) {
                maxVal = item
            }
        }

        val countTab: IntArray = IntArray(maxVal - minVal + 1)
        table.forEach { item -> countTab[item - minVal]++ }

        var tableIndex: Int = 0
        for (i in 0 until countTab.size) {
            while (countTab[i] != 0) {
                table[tableIndex] = i + minVal
                countTab[i]--
                tableIndex++
            }
        }

        return table
    }
}
