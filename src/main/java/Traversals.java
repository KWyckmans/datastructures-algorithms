import java.util.function.Consumer;

//public class Traversals {
//    public void preOrderTraversal(BinaryTree.Node node, Consumer<Integer> visitor) {
//        visitor.accept(node.value);
//
//        if(node.left != null) {
//            preOrderTraversal(node.left, visitor);
//        }
//
//        if(node.right != null){
//            preOrderTraversal(node.right, visitor);
//        }
//    }
//
//    public static void inOrderTraversal(BinaryTree.Node node, Consumer<Integer> visitor){
//
//        if(node.left != null) {
//            inOrderTraversal(node.left, visitor);
//        }
//
//        visitor.accept(node.value);
//
//        if(node.right != null){
//            inOrderTraversal(node.right, visitor);
//        }
//    }
//
//    public static void postOrderTraversal(BinaryTree.Node node, Consumer<Integer> visitor){
//
//        if(node.left != null) {
//            postOrderTraversal(node.left, visitor);
//        }
//
//        if(node.right != null){
//            postOrderTraversal(node.right, visitor);
//        }
//
//        visitor.accept(node.value);
//
//    }
//}