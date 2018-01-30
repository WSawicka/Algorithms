package main.sorting.impl;

import main.sorting.Sort;

import java.util.Arrays;

public class BubbleSort implements Sort<int[]> {
	private int[] table;

	public int[] getSortedData(int[] tab) {
		this.table = tab;
		sort();
		return table;
	}

	private void sort() {
		for (int i = 0; i < table.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < table.length - 1; j++) {
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
