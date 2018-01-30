package main.sorting.impl;

import main.sorting.Sort;

import java.util.Arrays;

public class SelectionSort implements Sort<int[]> {
	private int[] table;

	@Override
	public int[] getSortedData(int[] tab) {
		this.table = tab;
		sort();
		return table;
	}

	private void sort() {
		for (int i = 0; i < table.length; i++) {
			int[] copy = Arrays.copyOfRange(table, i, table.length);
			int minIndex = getMinValIndex(copy) + i;
			if (table[i] > table[minIndex]) {
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
