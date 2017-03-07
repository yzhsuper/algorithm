package common.algorithm;

public class Bubble {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] list = {1, 2, 5, 7, 3, 4, 10};
		list = bs.sorted(list);
		for (int i=0; i< list.length; i++) {
			System.out.println(list[i]);
		}
	}

}
