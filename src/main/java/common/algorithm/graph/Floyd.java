package common.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 弗洛伊德最短路径算法
 * 
 * 先统计每相邻2个顶点间的距离，如果不能直达，则距离为无穷远<br/>
 * 每个顶点都有可能使得另外两个顶点之间的距离变短
 * 阵S进行N次更新(0-k), k时顶点个数，第k次更新时，如果"a[i][j]的距离" > "a[i][k]+a[k][j]"，则更新a[i][j]为"a[i][k]+a[k][j]"
 * <br/>核心在于两边之和大于第三边
 * @author yangzhuo
 *
 */
public class Floyd {

	private int[][] data;
	private int length;
	private int max = Integer.MAX_VALUE;
	private int[][] path;
	
	public Floyd(int[][] data) {
		this.data = data;
		length = data.length;
		path = new int[length][length];
		this.shortestPath();
	}

	private void shortestPath() {
		int tmp;
		for (int k = 0; k < length; k++) {
			for (int x = 0; x < length; x++) {
				for (int y = 0; y < length; y++) {
					tmp = (data[x][k] == max || data[k][y]==max) ? max : (data[x][k] + data[k][y]);
					if (data[x][y] > tmp) {
						data[x][y] = tmp;
						path[x][y] = k;
					}
				}
			}
		}
		printArray(path);
	}
	
	public void getShortestPath(int v, int w) {
		boolean reverse = false;
		if (v > w) {
			reverse = true;
			int a = v;
			v = w;
			w = a;
		}
		ArrayList<Integer> pathList = new ArrayList<Integer>(8);
	    //求 0 到 3的最小路径
	    int k = path[v][w];
	    pathList.add(v);
	    while(k > 0){
	    	pathList.add(k);
	        k = path[k][w];
	    }
	    pathList.add(w);
	    if (reverse) {
	    	for (int i=pathList.size() - 1; i>=0; i--) {
	    		System.out.print(pathList.get(i) + " ");
	    	}
	    } else {
	    	System.out.println(pathList);
	    }
	}
	
	public void printArray(int[][] list) {
		for (int x=0; x<list.length; x++) {
			System.out.println(Arrays.toString(list[x]));
		}
	}
}
