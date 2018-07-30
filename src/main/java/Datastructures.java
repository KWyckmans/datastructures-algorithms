import be.wyckd.datastructures.Hashmap;
import be.wyckd.util.Person;
import be.wyckd.datastructures.BinaryTree;
import be.wyckd.datastructures.LinkedList;
import be.wyckd.datastructures.Queue;
import be.wyckd.datastructures.Stack;

import java.util.Random;

import static be.wyckd.datastructures.BinaryTree.*;

public class Datastructures {
    public static void main(String[] args) {
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
        System.out.println("List size: " + list.count());

        System.out.println("Sorting list:");
        System.out.println(list.sort());

        System.out.println(list.empty() ? "List is empty" : "List not empty");
        list.delete(2);
        System.out.println(list);

        list.search(2).ifPresent(System.out::println);
        System.out.println(!list.search(17).isPresent() ? "Not present" : "present");

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
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(8);
        tree.insert(4);
        tree.insert(16);
        tree.traverse(BinaryTree.PreOrderTraversal::traverse, BinaryTree.PrintVisitor::visit);
        System.out.println(" - - - - - - ");
        tree.insert(9);
        tree.insert(18);
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
//        tree.printPreOrder();

        tree.traverse(BinaryTree.PreOrderTraversal::traverse, BinaryTree.PrintVisitor::visit);
        System.out.println(" - - - - - - ");
        tree.traverse(BinaryTree.InOrderTraversal::traverse, BinaryTree.PrintVisitor::visit);
        System.out.println(" - - - - - - ");
        tree.traverse(BinaryTree.PostOrderTraversal::traverse, BinaryTree.PrintVisitor::visit);

        System.out.println("- - - - - list sorting testing - - - - - - - - - ");
        LinkedList sortingList = new LinkedList();
        System.out.println("empty list: " + sortingList.sort());
        sortingList.insert(1);
        System.out.println("1 element: " + sortingList.sort());
        sortingList.insert(1);
        sortingList.insert(1);
        sortingList.insert(1);
        sortingList.insert(1);
        System.out.println("identical elements: " + sortingList.sort());

        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            sortingList.insert(rand.nextInt(50) + 1);
        }
        System.out.println(sortingList.sort());

        System.out.println("- - - - - - - - Hashmap - - - - - - - - ");

        Hashmap<String, Person> people = new Hashmap<>();

        try{
            people.get("kevin");
        } catch (Hashmap.KeyNotFoundException e){
            System.err.println("Tried to retrieve an element that does not exist");
        }

        String[] names = {"Kevin", "Sanne", "Bal", "Slimmy", "Karel", "Pedro"};
        for(String name:names) {
            people.add(name, Person.from(name));
        }

        System.out.println(people);
    }
}
