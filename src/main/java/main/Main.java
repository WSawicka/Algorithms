package main;

import main.sorting.Sort;
import main.sorting.impl.InsertionSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] table = new int[n];

		Sort<int[]> insertionSort = new InsertionSort(n);
		for (int i = 0; i < n; i++) {
			table[i] = in.nextInt();
		}
		insertionSort.setData(table);
		int[] sorted = insertionSort.getSortedData();
		System.out.println(Arrays.toString(sorted));
	}
}
