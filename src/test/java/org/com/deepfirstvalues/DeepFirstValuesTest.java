package org.com.deepfirstvalues;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeepFirstValuesTest {
    @Test
    void test00() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        DeepFirstValues.depthFirstValues(a);

        assertEquals(List.of("a", "b", "d", "e", "c", "f"), DeepFirstValues.depthFirstValues(a));
    }

    @Test
    void test01() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        //    /
        //   g

        assertEquals(List.of("a", "b", "d", "e", "g", "c", "f"), DeepFirstValues.depthFirstValues(a));
    }

    @Test
    void test02() {
        Node<String> a = new Node<>("a");

        assertEquals(List.of("a"), DeepFirstValues.depthFirstValues(a));
    }

    @Test
    void test03() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");

        a.right = b;
        b.left = c;
        c.right = d;
        d.right = e;

         assertEquals(List.of("a", "b", "c", "d", "e"), DeepFirstValues.depthFirstValues(a));

    }

}
