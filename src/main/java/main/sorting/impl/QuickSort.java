package main.sorting.impl;

import main.sorting.Sort;

import java.util.LinkedList;
import java.util.List;

public class QuickSort implements Sort<int[]> {
	private int[] table;

	@Override
	public int[] getSortedData(int[] tab) {
		this.table = tab;
		sort(0, table.length - 1);
		return table;
	}

	private void sort(int startInd, int endInd) {
		List<Integer> left = new LinkedList<>();
		List<Integer> right = new LinkedList<>();
		int pivot = table[startInd];
		for (int i = startInd + 1; i <= endInd; i++) {
			if (table[i] < pivot) {
				left.add(table[i]);
			} else {
				right.add(table[i]);
			}
		}

		int pivotIndex = putIntoTable(startInd, left, pivot, right);
		if (startInd < endInd && (endInd - startInd) > 1) {
			if (startInd < pivotIndex) {
				sort(startInd, pivotIndex);
			}
			if (endInd > pivotIndex) {
				sort(pivotIndex + 1, endInd);
			}
		}
	}

	private int putIntoTable(int startInd, List<Integer> left, int pivot, List<Integer> right) {
		int ind = startInd;
		for (int i = 0; i < left.size(); i++, ind++) {
			table[ind] = left.get(i);
		}

		int pivotIndex = ind;
		table[ind] = pivot;

		ind++;
		for (int i = 0; i < right.size(); i++, ind++) {
			table[ind] = right.get(i);
		}
		return pivotIndex;
	}
}
