package main;

import main.sorting.Sort;
import main.sorting.impl.MergeSort;
import main.sorting.impl.QuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] table = new int[n];

		for (int i = 0; i < n; i++) {
			table[i] = in.nextInt();
		}
		Sort<int[]> sort = new QuickSort();
		int[] sorted = sort.getSortedData(table);
		System.out.println(Arrays.toString(sorted));
	}
}
