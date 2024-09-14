package org.com.treepathfinder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreePathFinderTest {

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

        assertEquals(List.of("a", "b", "e"), TreePathFinder.pathFinder(a, "e"));
    }

    @Test
    void test01() {
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

        assertEquals(null, TreePathFinder.pathFinder(a, "p"));
    }

    @Test
    void test02() {
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

        assertEquals(List.of("a", "c"), TreePathFinder.pathFinder(a, "c"));
    }

    @Test
    void test03() {
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

        assertEquals(List.of("a", "c","f","h"), TreePathFinder.pathFinder(a, "h"));

    }

    @Test
    void test04() {
        Node<String> x = new Node<>("x");

        //      x
        assertEquals(List.of("x"), TreePathFinder.pathFinder(x, "x"));

    }

    @Test
    void test05() {
        assertEquals(null, TreePathFinder.pathFinder(null, "x"));
    }

    @Test
    void test06() {
        Node<Integer> root = new Node<>(0);
        Node<Integer> curr = root;
        for (int i = 1; i <= 200; i += 1) {
            curr.right = new Node<>(i);
            curr = curr.right;
        }

        //      0
        //       \
        //        1
        //         \
        //          2
        //           \
        //            3
        //             .
        //              .
        //               .
        //              199
        //                \
        //                200

        List<Integer> expectedResult=new ArrayList<>();
        for (int i = 1; i <= 200; i += 1) {
            expectedResult.add(i);
        }
        assertEquals(expectedResult,TreePathFinder.pathFinder(root,116));
    }
}