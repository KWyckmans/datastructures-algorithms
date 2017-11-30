
public class Datastructures {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        System.out.println(list);
        System.out.println(list.count());
        System.out.println(list.empty() ? "List is empty" : "List not empty");

        list.insert(2);
        list.delete(3);

        list.insert(1);
        list.insert(2);
        list.insert(5);

        System.out.println(list);
        System.out.println(list.count());

        System.out.println(list.empty() ? "List is empty" : "List not empty");
        list.delete(2);
        System.out.println(list);

        list.search(2).ifPresent(System.out::println);
        System.out.println(!list.search(17).isPresent() ? "Not present": "present");

        System.out.println(" === Testing Stack implementation === ");

        Stack stack = new Stack();
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(" === Testing Queue implementation === ");

        Queue queue = new Queue();
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(" === Binary Tree === ");
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(16);
        tree.printPreOrder();
        System.out.println(" - - - - - - ");
        tree.insert(9);
        tree.insert(18);
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
//        tree.printPreOrder();

        tree.traverse(Traversals::preOrderTraversal, Visitors::printVisitor);
        System.out.println(" - - - - - - ");
        tree.traverse(Traversals::inOrderTraversal, Visitors::printVisitor);
        System.out.println(" - - - - - - ");
        tree.traverse(Traversals::postOrderTraversal, Visitors::printVisitor);
    }
}
