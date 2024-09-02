package org.com.deepfirstvalues;
import java.util.List;

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class DeepFirstValues {
    //Write a method, depthFirstValues, that takes in the root of a binary tree. The method should
    // return a List containing all values of the tree in depth-first order.
    public static List<String> depthFirstValues(Node<String> root) {
        return List.of();
    }
}
