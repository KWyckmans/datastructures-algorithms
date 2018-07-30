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

    public void traverse(BiConsumer<BinaryTree, Consumer<BinaryTree>> traversal, Consumer<BinaryTree> visitor) {
        traversal.accept(treeRoot, visitor);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                '}';
    }

    public static class PrintVisitor {
        public static void visit(BinaryTree tree) {
            System.out.println(tree);
        }
    }

    public static final class PreOrderTraversal {
        public static void traverse(BinaryTree tree, Consumer<BinaryTree> visitor) {
            visitor.accept(tree);

            if (tree.left != null) {
                traverse(tree.left, visitor);
            }

            if (tree.right != null) {
                traverse(tree.right, visitor);
            }
        }
    }

    public static class InOrderTraversal {
        public static void traverse(BinaryTree tree, Consumer<BinaryTree> visitor) {

            if (tree.left != null) {
                traverse(tree.left, visitor);
            }

            visitor.accept(tree);

            if (tree.right != null) {
                traverse(tree.right, visitor);
            }
        }

    }

    public static class PostOrderTraversal {
        public static void traverse(BinaryTree tree, Consumer<BinaryTree> visitor) {
            if (tree.left != null) {
                traverse(tree.left, visitor);
            }

            if (tree.right != null) {
                traverse(tree.right, visitor);
            }

            visitor.accept(tree);
        }
    }
}

//    public class Traversals {
//        public void preOrderTraversal(BinaryTree<T> node, Consumer<T> visitor) {
//            visitor.accept(node.value);
//
//            if (node.left != null) {
//                preOrderTraversal(node.left, visitor);
//            }
//
//            if (node.right != null) {
//                preOrderTraversal(node.right, visitor);
//            }
//        }
//
//       public  void inOrderTraversal(BinaryTree<T> node, Consumer<T> visitor) {
//
//            if (node.left != null) {
//                inOrderTraversal(node.left, visitor);
//            }
//
//            visitor.accept(node.value);
//
//            if (node.right != null) {
//                inOrderTraversal(node.right, visitor);
//            }
//        }
//
//        public void postOrderTraversal(BinaryTree<T> node, Consumer<T> visitor) {
//
//            if (node.left != null) {
//                postOrderTraversal(node.left, visitor);
//            }
//
//            if (node.right != null) {
//                postOrderTraversal(node.right, visitor);
//            }
//
//            visitor.accept(node.value);
//
//        }
//    }






