package main;

import main.sorting.Sort;
import main.sorting.impl.MergeSort;
import main.sorting.impl.SelectionSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] table = new int[n];

		Sort<int[]> sort = new MergeSort(n);
		for (int i = 0; i < n; i++) {
			table[i] = in.nextInt();
		}
		sort.setData(table);
		int[] sorted = sort.getSortedData();
		System.out.println(Arrays.toString(sorted));
	}
}
