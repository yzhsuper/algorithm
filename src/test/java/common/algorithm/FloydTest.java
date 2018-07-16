package common.algorithm;

import java.util.Arrays;

import org.junit.Test;

import common.algorithm.graph.Floyd;

public class FloydTest {
	
	int max = Integer.MAX_VALUE;
	
	int[][] list = {
		{ 0, 12, max, max, max, 16, 14 }, 
		{ 12, 0, 10, max, max, 7, max }, 
		{ max, 10, 0, 3, 5, 6, max },
		{ max, max, 3, 0, 4, max, max },
		{ max, max, 5, 4, 0, 2, 8},
		{ 16, 7, 6, max, 2, 0, 9},
		{ 14, max, max, max, 8, 9, 0}
	};

	@Test
	public void selectTest() {
//		for (int x=0; x<list.length; x++) {
//			System.out.println(Arrays.toString(list[x]));
//		}
		Floyd ss = new Floyd(list);
//		for (int x=0; x<list.length; x++) {
//			System.out.println(Arrays.toString(list[x]));
//		}
		ss.getShortestPath(3, 0);
	}

}
