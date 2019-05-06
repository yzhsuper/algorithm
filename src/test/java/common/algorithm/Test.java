package common.algorithm;

import common.algorithm.sort.SelectSort;

public class Test {

	public static void main(String[] args) {

		SelectSort sort = new SelectSort();
		int[] a = {1, 4,5 ,6,7,8,3};
		sort.sorted(a);
//		Thread childThread = new Thread(new ClildThread());
//		childThread.setName("daemon test");
////		childThread.setDaemon(true);
//		System.out.println(childThread.isDaemon());
//		childThread.start();
	}
}
