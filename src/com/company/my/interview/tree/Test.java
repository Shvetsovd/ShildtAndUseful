package company.my.interview.tree;

/**
 * Created by user on 19.04.2018.
 */
public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(7);
        tree.add(3);
        tree.add(2);
        tree.add(8);
        tree.add(1);

        System.out.println(tree);
        System.out.println(tree.contains(7));
        tree.remove(7);
        System.out.println(tree);
        System.out.println(tree.contains(7));
    }
}
