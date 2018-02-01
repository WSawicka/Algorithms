package main.sorting.impl;

import main.sorting.Sort;

import java.util.Arrays;

public class RadixSort implements Sort<int[]> {
	private int[] table;

	public int[] getSortedData(int[] tab) {
		this.table = tab;
		sort();
		return table;
	}

	private void sort() {
		int max = table[0];
		for (int i = 1; i < table.length; i++) {
			if (Math.abs(table[i]) > max) {
				max = Math.abs(table[i]);
			}
		}

		for (int i = 1; max / i > 0; i *= 10) {
			sortByDigit(i);
		}
	}

	private void sortByDigit(int digit) {
		int[] output = Arrays.copyOf(table, table.length);
		int[] count = new int[10];

		//TODO: fix problem with values < 0
		for (int value : output) {
			count[(value / digit) % 10]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = output.length - 1; i >= 0; i--) {
			int value = output[i];
			table[count[(value / digit) % 10] - 1] = value;
			count[(value / digit) % 10]--;
		}
		System.out.println(Arrays.toString(table));
	}
}
