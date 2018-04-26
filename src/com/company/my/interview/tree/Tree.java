package company.my.interview.tree;

/**
 * Created by user on 19.04.2018.
 */
public class Tree {
    private static final class Node {
        private Node left;
        private int value;
        private Node right;

        private Node(Node left, int value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }

    Node root;
    int size;

    public boolean add(int value) {
        if (containsValue(root, value)) {
            return false;
        }
        root = addRecursive(root, value);
        size++;
        return true;
    }

    private Node addRecursive(Node root, int value) {
        if (root == null) {
            return new Node(null, value, null);
        }
        if (value < root.value) {
            root.left = addRecursive(root.left, value);
        } else {
            root.right = addRecursive(root.right, value);
        }
        return root;
    }

    public boolean contains(int value) {
        return containsValue(root, value);
    }

    private boolean containsValue(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value < root.value) {
            return containsValue(root.left, value);
        } else if (value > root.value) {
            return containsValue(root.right, value);
        } else {
            return true;
        }
    }

    public boolean remove(int value){
        if (!containsValue(root, value)){
            return false;
        }
        root = removeRecursive(root, value);
        size--;
        return true;
    }

    private Node removeRecursive(Node root, int value) {
        if (value < root.value){
            root.left = removeRecursive(root.left, value);
        } else if (value > root.value){
            root.right = removeRecursive(root.right, value);
        } else {
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            int subValue = getMinValue(root.right);
            Node subRoot = new Node(null, subValue, null);
            subRoot = addAllValues(root.left, subRoot);
            root = addAllValues(root.right, subRoot);
        }
        return root;
    }

    private Node addAllValues(Node root, Node newRoot) {
        if (root == null){
            return null;
        }
        addAllValues(root.left, newRoot);
        newRoot = addRecursive(newRoot, root.value);
        addAllValues(root.right, newRoot);
        return newRoot;
    }

    private int getMinValue(Node root) {
        if (root.left == null){
            return root.value;
        }
        return getMinValue(root.left);
    }

    @Override
    public String toString() {
        return "Tree [" +
                toStringRecursive(root, "").trim() +
                "]";
    }

    private String toStringRecursive(Node root, String s) {
        if (root == null) {
            return s;
        }
        s = toStringRecursive(root.left, s);
        s += root.value + " ";
        s = toStringRecursive(root.right, s);
        return s;
    }
}
