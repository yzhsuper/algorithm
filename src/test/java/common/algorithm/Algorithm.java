package common.algorithm;

import org.junit.Test;

public class Algorithm {
	
	int[] list = {70, 1, 5, 2, 7, 3, 4, 10, 20, 31, 15, 80, 40, 69, 85, 13};
	
	@Test
	public void selectTest() {
		SelectSort ss = new SelectSort();
		list = ss.sorted(list);
		for (int i=0; i< list.length; i++) {
			System.out.println(list[i]);
		}
		
	}
	
	@Test
	public void bubbleTest() {
		BubbleSort bs = new BubbleSort();
		list = bs.sorted(list);
		for (int i=0; i< list.length; i++) {
			System.out.println(list[i]);
		}
		
	}
}
