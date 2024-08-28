package org.example.bredthfirstvalues;


import org.example.breadthfirstvalue.Node;
import org.example.breadthfirstvalue.Source;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthFirstValuesTest {

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

        Source.breadthFirstValues(a);

        assertEquals(List.of("a", "b", "c", "d", "e", "f"), Source.breadthFirstValues(a));
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
        Node<String> h = new Node<>("h");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        //    /       \
        //   g         h


        assertEquals(List.of("a", "b", "c", "d", "e", "f", "g", "h"), Source.breadthFirstValues(a));
    }

    @Test
    void test02() {
        Node<String> a = new Node<>("a");

        //      a

        assertEquals(List.of("a"), Source.breadthFirstValues(a));

    }

    @Test
    void test03() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> x = new Node<>("x");

        a.right = b;
        b.left = c;
        c.left = x;
        c.right = d;
        d.right = e;

        //      a
        //       \
        //        b
        //       /
        //      c
        //    /  \
        //   x    d
        //         \
        //          e

        assertEquals(List.of("a", "b", "c", "x", "d", "e"), Source.breadthFirstValues(a));
    }

    @Test
    void test04() {
         assertEquals(List.of(), Source.breadthFirstValues(null));
    }
}
