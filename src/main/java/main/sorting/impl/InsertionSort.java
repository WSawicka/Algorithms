package main.sorting.impl;

import main.sorting.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertionSort implements Sort<int[]> {
	private int[] table;
	private int n;

	public InsertionSort(int n) {
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
		for (int i = 1; i < n; i++) {
			if (table[i] < table[i - 1]) {
				int lastSmaller = getLastSmallerIndex(i);
				swapAllBetween(lastSmaller, i);
			}
		}
	}

	private int getLastSmallerIndex(int valueIndex) {
		for (int i = valueIndex - 1; i >= 0; i--) {
			if (table[i] < table[valueIndex]) {
				return i + 1;
			}
		}
		return 0;
	}

	private void swapAllBetween(int from, int to) {
		List<Integer> tableCopy = IntStream.of(table).boxed().collect(Collectors.toList());
		List<Integer> swapped = new ArrayList<>();

		swapped.addAll(tableCopy.subList(0, from));
		swapped.add(tableCopy.get(to));
		tableCopy.remove(to);
		swapped.addAll(tableCopy.subList(from, table.length - 1));
		table = swapped.stream().mapToInt(i -> i).toArray();
	}
}
