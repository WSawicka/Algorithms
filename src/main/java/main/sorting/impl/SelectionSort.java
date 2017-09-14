package main.sorting.impl;

import main.sorting.Sort;

import java.util.Arrays;

public class SelectionSort implements Sort<int[]> {
	private int[] table;
	private int n;

	public SelectionSort(int n) {
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

	private void sort() {
		for (int i = 0; i < n; i++) {
			int[] copy = Arrays.copyOfRange(table, i, n);
			int minIndex = getMinValIndex(copy) + i;
			if (table[i] > table[minIndex]){
				int temp = table[i];
				table[i] = table[minIndex];
				table[minIndex] = temp;
			}
		}
	}

	private int getMinValIndex(int[] tab) {
		int min = 0;
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] < tab[min]) {
				min = i;
			}
		}
		return min;
	}
}
