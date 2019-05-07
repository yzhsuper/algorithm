package common.algorithm.tree;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class AVLTreeTest extends TestCase {

    @Test
    public void testBreadthFirstSearch() {
        int[] a = { 5, 4, 7, 1, 2};
        AVLTree tree = new AVLTree();
        for (int i : a) {
            tree.insert(i);
        }
        tree.breadthFirstSearch();
    }
}