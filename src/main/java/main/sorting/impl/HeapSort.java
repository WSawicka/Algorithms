package main.sorting.impl;

import main.sorting.Sort;

public class HeapSort implements Sort<int[]> {
	private int[] table;

	@Override
	public int[] getSortedData(int[] tab) {
		this.table = tab;
		sort();
		return table;
	}

	private void sort() {
		for (int i = table.length / 2 - 1; i >= 0; i--) {
			heapify(i, table.length);
		}
		for (int i = table.length - 1; i >= 0; i--) {
			int temp = table[0];
			table[0] = table[i];
			table[i] = temp;
			heapify(0, i);
		}
	}

	private void heapify(int i, int n) {
		int max = i;

		int left = getLeft(i);
		if (left < n && table[left] > table[max]) {
			max = left;
		}

		int right = getRight(i);
		if (right < n && table[right] > table[max]) {
			max = right;
		}

		if (max != i) {
			int temp = table[max];
			table[max] = table[i];
			table[i] = temp;

			heapify(max, n);
		}
	}

	private int getLeft(int i) {
		return 2 * i + 1;
	}

	private int getRight(int i) {
		return 2 * i + 2;
	}
}
