import jdk.nashorn.internal.ir.FunctionCall;

import java.util.concurrent.Callable;
import java.util.function.*;

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

    public void printPreOrder(){
        if(treeRoot != null){
            visit(treeRoot);
        }
    }

    public void printPostOrder(){

    }

    private void visit(Node node){
        System.out.println(node.value);

        if(node.left != null) {
            visit(node.left);
        }

        if(node.right != null){
            visit(node.right);
        }

    }


    public boolean find(int value) {
        return false;
    }

    public void traverse(BiConsumer<Node, Consumer<Integer>> traversal, Consumer<Integer> visitor){
        traversal.accept(treeRoot, visitor);
    }

    public class Node {
        public Node left;
        public Node right;
        public int value;

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


}




