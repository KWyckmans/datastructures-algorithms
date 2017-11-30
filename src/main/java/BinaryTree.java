import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BinaryTree {
    private Node treeRoot = null;

    public BinaryTree() {
    }

    public void insert(int value) {
        treeRoot = this.insert(treeRoot, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
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

    void traverse(BiConsumer<Node, Consumer<Integer>> traversal, Consumer<Integer> visitor) {
        traversal.accept(treeRoot, visitor);
    }

    class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class Visitors {
        static void printVisitor(int value) {
            System.out.println(value);
        }
    }

    static class Traversals {
        static void preOrderTraversal(BinaryTree.Node node, Consumer<Integer> visitor) {
            visitor.accept(node.value);

            if (node.left != null) {
                preOrderTraversal(node.left, visitor);
            }

            if (node.right != null) {
                preOrderTraversal(node.right, visitor);
            }
        }

        static void inOrderTraversal(BinaryTree.Node node, Consumer<Integer> visitor) {

            if (node.left != null) {
                inOrderTraversal(node.left, visitor);
            }

            visitor.accept(node.value);

            if (node.right != null) {
                inOrderTraversal(node.right, visitor);
            }
        }

        static void postOrderTraversal(BinaryTree.Node node, Consumer<Integer> visitor) {

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




