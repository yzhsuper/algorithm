package common.algorithm;

import org.junit.Test;

public class Algorithm {
	
	int[] list = {70, 1, 5, 2, 7, 3, 4, 10, 20, 31, 15, 80, 40, 69, 85, 13};
	
	@Test
	public void selectTest() {
		SelectSort ss = new SelectSort();
		list = ss.sorted(list);
		
	}
	
//	@Test
//	public void bubbleTest() {
//		BubbleSort bs = new BubbleSort();
//		list = bs.sorted(list);
//	}
}
