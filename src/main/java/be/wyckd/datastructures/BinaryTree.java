package be.wyckd.datastructures;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTree<T> treeRoot = null;

    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private T value;

    public BinaryTree() {
    }

    private BinaryTree(T value) {
        this.value = value;
    }

    public void insert(T value) {
        treeRoot = this.insert(treeRoot, value);
    }

    private BinaryTree<T> insert(BinaryTree<T> root, T value) {
        if (root == null) {
            return new BinaryTree<>(value);
        } else if (root.value.compareTo(value) > 0) {
            root.left = insert(root.left, value);
        } else if (root.value.compareTo(value) < 0) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void traverse(Traverser traversal, Visitor visitor) {
        traversal.accept(treeRoot, visitor);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                '}';
    }

    public interface Visitor extends Consumer<BinaryTree> {
        static void printVisitor(BinaryTree tree) {
            System.out.println(tree.value);
        }
    }

    public interface Traverser extends BiConsumer<BinaryTree, Consumer<BinaryTree>>{
        static void preOrderTraverser(BinaryTree tree, Consumer<BinaryTree> visitor) {
            visitor.accept(tree);

            if (tree.left != null) {
                preOrderTraverser(tree.left, visitor);
            }

            if (tree.right != null) {
                preOrderTraverser(tree.right, visitor);
            }
        }

        static void inOrderTraverser(BinaryTree tree, Consumer<BinaryTree> visitor) {
            if (tree.left != null) {
                inOrderTraverser(tree.left, visitor);
            }

            visitor.accept(tree);

            if (tree.right != null) {
                inOrderTraverser(tree.right, visitor);
            }
        }

        static void postOrderTraverser(BinaryTree tree, Consumer<BinaryTree> visitor) {
            if (tree.left != null) {
                postOrderTraverser(tree.left, visitor);
            }

            if (tree.right != null) {
                postOrderTraverser(tree.right, visitor);
            }

            visitor.accept(tree);

        }
    }
}



