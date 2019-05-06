package common.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 
 * @author yang
 *
 */
public class SelectSort implements SortBase {

	@Override
	public int[] sorted(int[] list) {
		int min;
		for (int i = 0; i < list.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[min] > list[j]) {
					min = j;
				}
			}
			if (min != i) {
				swap(list, min, i);
			}
			System.out.println(Arrays.toString(list));
		}
		return list;
	}

}