package common.algorithm.sort;

import java.util.Arrays;

/**
 * <b>冒泡排序</b><br/>
 * 外层循环控制需要循环的次数,N个数字要排序完成，总共进行N-1趟排序
 * 内循环每次执行后,最大值都会在最后面,所以下一次执行循环时就不需要再与后面已经排好的比较
 * 
 * @author yangzhuo
 */
public class BubbleSort implements SortBase {
	@Override
	public int[] sorted(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					swap(list, j, j + 1);
				}
			}
			System.out.println(Arrays.toString(list));
		}
		return list;
	}

}
