package common.algorithm;

/**
 * 冒泡排序
 * @author yang
 *
 */
public class BubbleSort implements SortBase {

	@Override
	public int[] sorted(int[] list) {
		int tmp;
		for (int i=0; i < list.length - 1; i++) {
			for (int j=0; j< list.length - 1; j++) {
				if (list[j] > list[j + 1]) {
					tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				}
			}
		}
		return list;
	}

}
