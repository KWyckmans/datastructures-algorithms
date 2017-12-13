package datastructures;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BinaryTree {
    private BinaryTree treeRoot = null;

    private BinaryTree left;
    private BinaryTree right;
    private int value;

    public BinaryTree() {
    }

    private BinaryTree(int value){
        this.value = value;
    }

    public void insert(int value) {
        treeRoot = this.insert(treeRoot, value);
    }

    private BinaryTree insert(BinaryTree root, int value) {
        if (root == null) {
            return new BinaryTree(value);
        } else if (root.value > value) {
            root.left = insert(root.left, value);
        } else if (root.value < value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public boolean find(int value) {
        return false;
    }

    public void traverse(BiConsumer<BinaryTree, Consumer<Integer>> traversal, Consumer<Integer> visitor) {
        traversal.accept(treeRoot, visitor);
    }

    public static class Visitors {
        public static void printVisitor(int value) {
            System.out.println(value);
        }
    }

    public static class Traversals {
        public static void preOrderTraversal(BinaryTree node, Consumer<Integer> visitor) {
            visitor.accept(node.value);

            if (node.left != null) {
                preOrderTraversal(node.left, visitor);
            }

            if (node.right != null) {
                preOrderTraversal(node.right, visitor);
            }
        }

       public static void inOrderTraversal(BinaryTree node, Consumer<Integer> visitor) {

            if (node.left != null) {
                inOrderTraversal(node.left, visitor);
            }

            visitor.accept(node.value);

            if (node.right != null) {
                inOrderTraversal(node.right, visitor);
            }
        }

        public static void postOrderTraversal(BinaryTree node, Consumer<Integer> visitor) {

            if (node.left != null) {
                postOrderTraversal(node.left, visitor);
            }

            if (node.right != null) {
                postOrderTraversal(node.right, visitor);
            }

            visitor.accept(node.value);

        }
    }

}




