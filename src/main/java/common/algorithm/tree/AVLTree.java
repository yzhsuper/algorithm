package common.algorithm.tree;

import java.util.LinkedList;

/**
 * 平衡2叉树（AVL树）
 * 任意一个节点，它的左右子树的差的绝对值一定小于2
 * @author yangzhuo
 */
public class AVLTree {

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
		rebuild(node, data);
	}
	
	
	/**
	 * 插入后，检查平衡
	 * balance: 平衡因子，左子树高度减去右子树高度
	 * 不平衡节点的出现只可能出现在插入节点（叶子节点）的父辈节点上
	 * @param node 插入节点父节点
	 */
	private void rebuild(Node node, int data) {
		while (node != null) {
			node.updateHeight();
			int balance = node.getBalance();
			if (balance == 2) {
				// 左侧树高
				if (node.left.data > data) {
					// LL
					rightRotate(node);
				} else {
					// LR
					leftRotate(node.left);
					rightRotate(node);
				}
			} else if (balance == -2) {
				if (node.right.data < data) {
					// RR
					leftRotate(node);
				} else {
					// RL
					rightRotate(node.right);
					leftRotate(node);
				}
			}
			node = node.parent;
		}
	}
	
//	private void fixBalance(Node node, int type) {
//		if (type == LEFT) {
//			leftRotate(node);
//		} else {
//			rightRotate(node);
//		}
//	}

	/**
	 * 坐旋转，说明右子树比左子树高，node节点一定有右子树
	 * 将node节点的右节点x升一级，将node挂在x的左节点
	 * 将x以前的左节点挂在node的右节点
	 * @param node node 表示失衡的节点
	 */
	private void leftRotate(Node node) {

		Node x = node.right;

		if (node.parent == null) {
			// 父节点为null，node是根节点,旋转后x为新的根节点
			root = x;
		} else {
			node.parent.left = x;
		}

		Node tmp = x.left;
		x.left = node;
		node.right = tmp;

	}


	/**
	 * 右旋转，说明左子树比右子树高，node节点一定有左子树
	 * @param node 表示失衡的节点
	 */
	private void rightRotate(Node node) {
		Node x = node.left;

		if (node.parent == null) {
			// 父节点为null，node是根节点,旋转后x为新的根节点
			root = x;
		} else {
			node.parent.left = x;
		}

		Node tmp = x.right;

		x.right = node;
		node.left = tmp;

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

}
