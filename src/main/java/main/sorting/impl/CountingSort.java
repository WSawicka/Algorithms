package main.sorting.impl;

import main.sorting.Sort;

public class CountingSort implements Sort<int[]> {
	private int[] table;

	@Override
	public int[] getSortedData(int[] tab) {
		this.table = tab;
		sort();
		return table;
	}

	private void sort() {
		int minVal = table[0];
		int maxVal = table[0];

		for (int i = 1; i < table.length; i++) {
			if (table[i] < minVal) {
				minVal = table[i];
			} else if (table[i] > maxVal) {
				maxVal = table[i];
			}
		}

		int[] countTab = new int[maxVal - minVal + 1];
		for (int value : table) {
			countTab[value - minVal]++;
		}

		int tableIndex = 0;
		for (int i = 0; i < countTab.length; i++) {
			while (countTab[i] != 0) {
				table[tableIndex] = i + minVal;
				countTab[i]--;
				tableIndex++;
			}
		}
	}
}
