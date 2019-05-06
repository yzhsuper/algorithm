package common.algorithm.sort;

import java.util.Arrays;

public interface SortBase {

	int[] sorted(int[] list);

	default void swap(int[] data, int x, int y) {
		int t = data[x];
        data[x]=data[y];
        data[y] = t;
	}
	
	default void show(int[] list) {
		System.out.println(Arrays.toString(list));
	}
}
