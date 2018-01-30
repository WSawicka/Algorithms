package main.sorting.impl;

import main.sorting.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort implements Sort<int[]> {
	private int[] table;

	public MergeSort(int n) {
		this.table = new int[n];
	}

	@Override
	public void setData(int[] tab) {
		this.table = Arrays.copyOf(tab, tab.length);
	}

	@Override
	public int[] getSortedData() {
		return sort(table);
	}

	private int[] sort(int[] tab) {
		if (tab.length == 1) {
			return tab;
		} else if (tab.length == 2) {
			if (tab[0] > tab[1]) {
				int temp = tab[0];
				tab[0] = tab[1];
				tab[1] = temp;
			}
			return tab;
		} else {
			int[] left = Arrays.copyOfRange(tab, 0, tab.length / 2);
			int[] right = Arrays.copyOfRange(tab, tab.length / 2, tab.length);

			List<Integer> leftList = IntStream.of(sort(left)).boxed().collect(Collectors.toList());
			List<Integer> rightList = IntStream.of(sort(right)).boxed().collect(Collectors.toList());
			return getMerged(leftList, rightList).stream().mapToInt(m -> m).toArray();
		}
	}

	private List<Integer> getMerged(List<Integer> left, List<Integer> right) {
		List<Integer> merged = new ArrayList<>();
		while (true) {
			if (left.size() != 0 && right.size() != 0) {
				if (left.get(0) < right.get(0)) {
					merged.add(left.get(0));
					left.remove(0);
				} else {
					merged.add(right.get(0));
					right.remove(0);
				}
			} else if (left.size() == 0) {
				merged.addAll(right);
				break;
			} else {
				merged.addAll(left);
				break;
			}
		}
		return merged;
	}
}
