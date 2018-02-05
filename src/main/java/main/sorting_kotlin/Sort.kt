package main.sorting_kotlin

interface Sort<T> {
    fun getSorted(table: T): T
}