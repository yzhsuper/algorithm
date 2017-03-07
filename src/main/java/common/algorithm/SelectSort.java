package common.algorithm;

/**
 * 选择排序
 * @author yang
 *
 */
public class SelectSort implements SortBase {

	@Override
	public int[] sorted(int[] list) {
		int min, tmp;
		for (int i=0; i < list.length - 1; i++) {
			min = i;
			for (int j=i + 1; j< list.length; j++) {
				if (list[min] > list[j]) {
					min = j;
				}
			}
			
			if (min != i) {
				tmp = list[min];
				list[min] = list[i];
				list[i] = tmp;
			}
		}
		return list;
	}

}
