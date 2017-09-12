package main.sorting.impl;

import main.sorting.Sort;

import java.util.Arrays;

public class BubbleSort implements Sort<int[]> {
	private int[] table;
	private int n;

	public BubbleSort(int n) {
		this.n = n;
		this.table = new int[n];
	}

	public void setData(int[] tab) {
		this.table = Arrays.copyOf(tab, tab.length);
	}

	public int[] getSortedData() {
		sort();
		return table;
	}

	private void sort() {
		for (int i = 0; i < n; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - 1; j++) {
				if (table[j] > table[j + 1]) {
					swap(j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) break;
		}
	}

	private void swap(int left, int right) {
		int temp = table[left];
		table[left] = table[right];
		table[right] = temp;
	}
}
