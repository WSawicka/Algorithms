package main.sorting.impl;

import main.sorting.Sort;

import java.util.Arrays;

public class InsertionSort implements Sort<int[]> {
	private int[] table;
	private int n;

	public InsertionSort(int n){
		this.n = n;
		this.table = new int[n];
	}

	@Override
	public void setData(int[] tab) {
		this.table = Arrays.copyOf(tab, tab.length);
	}

	@Override
	public int[] getSortedData() {
		sort();
		return table;
	}

	private void sort(){

	}
}
