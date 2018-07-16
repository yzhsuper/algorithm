package common.algorithm;

public interface SortBase {

	public int[] sorted(int[] list);
	
	public default void swap(int[] data, int x, int y) {
		int t = data[x];
        data[x]=data[y];
        data[y] = t;
	}
}
