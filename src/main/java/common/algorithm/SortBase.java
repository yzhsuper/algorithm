package common.algorithm;

public interface SortBase {

	public int[] sorted(int[] list);
	
	public default void swap(int a, int b) {
		int c = a;
		a = b;
		b = c;
	}
}
