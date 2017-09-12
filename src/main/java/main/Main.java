package main;

import main.sorting.Sort;
import main.sorting.impl.BubbleSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] table = new int[n];

		Sort<int[]> bubbleSort = new BubbleSort(n);
		for (int i = 0; i < n; i++) {
			table[i] = in.nextInt();
		}
		bubbleSort.setData(table);
		int[] sorted = bubbleSort.getSortedData();
		System.out.println(Arrays.toString(sorted));
	}
}
