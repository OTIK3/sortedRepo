package sorts.init;

import sorts.InternalSort;

import java.util.ArrayList;
import java.util.List;

public class TreeInternalSort extends InternalSort {
    private Node node = null;

    public TreeInternalSort(List<Integer> array) {
        super(array);
    }

    public TreeInternalSort(int size, int bound) {
        super(size, bound);
    }

    public TreeInternalSort(int size, int bound, boolean isUnique) {
        super(size, bound, isUnique);
    }

    private static class Node{
        private final int value;
        public Node left = null;
        public Node right = null;

        public Node(int value){
            this.value = value;
        }
    }

    @Override
    public void sort() {
        sortedArray.forEach(v -> node = insert(node, v));
        sortedArray = new ArrayList<>();
        searchLeft(node);
    }

    //симметричный обход bst дерева
    private void searchLeft(Node node){
        if (node != null) {
            searchLeft(node.left);
            sortedArray.add(node.value);
            searchLeft(node.right);
        }
    }

    private Node insert(Node node, int value){
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;
    }
}
