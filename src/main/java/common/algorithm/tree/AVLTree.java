package common.algorithm.tree;

import java.util.LinkedList;

/**
 * @author yangzhuo
 */
public class AVLTree {

	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	
	private Node root;

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
//		insertRecursive(root, data);
		insertLoop(root, data);
	}

	/**
	 * 使用递归方式插入
	 * @param node
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unused")
	private void insertRecursive(Node node, int data) {
		if (data < node.data) {
			if (node.left == null) {
				node.left = new Node(node, data);
			} else {
				insertRecursive(node.left, data);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(node, data);
			} else {
				insertRecursive(node.right, data);
			}
		}
	}
	
	
	/**
	 * 使用循环方式插入
	 * @param root
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unused")
	private void insertLoop(Node root, int data) {
		Node node = root;
		while(true) {
			if (data < node.data) {
				if (node.left == null) {
					node.left = new Node(node, data);
					break;
				} else {
					node = node.left;
				}
			} else {
				if (node.right == null) {
					node.right = new Node(node, data);
					break;
				} else {
					node = node.right;
				}
			}
		}
		System.out.println("before rotate------------------");
		breadthFirstSearch();
		rebuild(node, data);
		System.out.println("after rotate------------------");
		breadthFirstSearch();
	}
	
	
	/**
	 * 插入后，检查平衡
	 * 不平衡节点的出现只可能出现在插入节点（叶子节点）的父辈节点上
	 * @param node
	 */
	private void rebuild(Node node, int data) {
		while (node != null) {
			node.updateHeight();
			int balance = node.getBalance();
			if (balance == 2) {
				// 左侧树高
				if (node.left.data > data) {
					// LL
					fixBalance(node, RIGHT);
				} else {
					// LR
					fixBalance(node.left, LEFT);
					breadthFirstSearch();
					fixBalance(node, RIGHT);
				}
			} else if (balance == -2) {
				if (node.right.data < data) {
					// RR
					fixBalance(node, LEFT);
				} else {
					// RL
					fixBalance(node.right, RIGHT);
					fixBalance(node, LEFT);
				}
			}
//			System.out.println(node + ", balance=" + node.getBalance());
			node = node.parent;
		}
//		System.out.println("------------------");
	}
	
	private void fixBalance(Node node, int type) {
		if (type == LEFT) {
			leftRotate(node);
		} else {
			rightRotate(node);
		}
	}

	private Node leftRotate(Node node) {

		Node x = node.right;
		if (node == root) {
			root = x;
		}
		if (node.parent != null) {
			node.parent.left = x;
		}

		Node tmp = x.left;

		x.left = node;
		node.right = tmp;

		node.updateHeight();
		x.updateHeight();

		return x;
	}

	private Node rightRotate(Node node) {
		Node x = node.left;
		if (node == root) {
			root = x;
		}

		if (node.parent != null) {
			node.parent.left = x;
		}

		Node tmp = x.right;

		x.right = node;
		node.left = tmp;

		node.updateHeight();
		x.updateHeight();
		return x;
	}

	/**
	 * 广度优先遍历
	 */
	public void breadthFirstSearch() {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while (!list.isEmpty()) {
			Node tmp = list.poll();
			System.out.print(tmp.data + "-");
			if (tmp.left != null) {
				list.add(tmp.left);
			}
			if (tmp.right != null) {
				list.add(tmp.right);
			}
		}
		System.out.println("\n");
	}

	/**
	 * 前序遍历
	 * @param node
	 */
	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data);
		System.out.print("-");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * 中序遍历，结果为递增数列
	 * @param node
	 */
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data);
		System.out.print("-");
		inOrder(node.right);
	}
	
	/**
	 * 后序遍历
	 * @param node
	 */
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
		System.out.print("-");
	}
	
	private final static class Node {
		private Node parent;
		private Node left;
		private Node right;

		private int data;
		private int depth;

		private Node(int data) {
			this.data = data;
			this.depth = 1;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		private Node(Node parent, int data) {
			this(data);
			this.parent = parent;
		}
		
//		public int getHeight() {
//			if (!update_depth) {
//				this.depth = getHeight(this);
//				this.update_depth = true;
//			}
//			return depth;
//		}

		private int updateHeight() {
			this.depth = getHeight(this);
			return depth;
		}
		
		private int getHeight(Node node) {
			if (node == null) {
				return 0;
			}
			int left = getHeight(node.left);
			int right = getHeight(node.right);
			return 1 + Math.max(left, right);
		}

		private int getBalance() {
			int left = this.left != null ? this.left.depth: 0;
			int right = this.right != null ? this.right.depth: 0;
			return left - right;
		}

		@Override
		public String toString() {
			return "Node:data=" + data + ", depth=" + depth;
		}
	}

	public static void main(String[] args) {
//		, 8, 9, 1, 2
//		int[] a = { 5, 4, 7, 6, 10, 8};
		int[] a = { 5, 4, 7, 1, 2};
		AVLTree tree = new AVLTree();
		for (int i : a) {
			tree.insert(i);
		}
//		tree.preOrder(tree.root);
//		System.out.println("");
//		tree.inOrder(tree.root);
//		System.out.println("");
//		tree.postOrder(tree.root);
	}
}
