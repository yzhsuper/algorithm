package common.algorithm.sort;

public class QuickRecursiveSort implements SortBase {

	@Override
	public int[] sorted(int[] list) {
		this.show(list);
		this.quick_recursive_sort(list, 0, list.length - 1);
		return null;
	}
	
	/**
	 * @param list
	 * @param left
	 * @param right
	 */
	public void quick_recursive_sort(int[] list, int start, int end) {
		if (start >= end) return;
		int index = 5, base = list[index];
		int left = start, right = end;
		while (left < right) {
			while (right > left && list[right] >= base) {
				right--;
	            if (right == index) break;
	            right--;
			}
			// 重左到右, 直到比base大的
			while (left < right && list[left] <= base) {
				left++;
			}
			System.out.println("left: " + left + ", right:" + right + ", base:" + base);
			if (left < right) {
				this.swap(list, left, right);
				this.show(list);
				right -= 1;
	            if (left < right) left += 1;
//				if (left > 0) left ++;
			}
		}
		this.swap(list, index, left);
		this.show(list);
//		
//		System.out.println("base:" + base + ", index:" + (left-1));
//		if (left-1 != index) {
//			System.out.println("left: " + start + "--" + (left - 2) + ", right:" + (left) + "--" + end);
//			quick_recursive_sort(list, start, left-2);
//			quick_recursive_sort(list, left, end);
//		}
	}

}
