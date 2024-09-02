package org.com.maxroottoleafpathsum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxRooToLeafPathSumTest {

    @Test
    void test00() {
        Node<Double> a = new Node<>(3.);
        Node<Double> b = new Node<>(11.);
        Node<Double> c = new Node<>(4.);
        Node<Double> d = new Node<>(4.);
        Node<Double> e = new Node<>(-2.);
        Node<Double> f = new Node<>(1.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //       3
        //    /    \
        //   11     4
        //  / \      \
        // 4   -2     1

        assertEquals(18D, MaxRooToLeafPathSum.maxPathSum(a));
    }

    @Test
    void test01() {
        Node<Double> a = new Node<>(5.);
        Node<Double> b = new Node<>(11.);
        Node<Double> c = new Node<>(54.);
        Node<Double> d = new Node<>(20.);
        Node<Double> e = new Node<>(15.);
        Node<Double> f = new Node<>(1.);
        Node<Double> g = new Node<>(3.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

        //        5
        //     /    \
        //    11    54
        //  /   \
        // 20   15
        //      / \
        //     1  3

        assertEquals(59D, MaxRooToLeafPathSum.maxPathSum(a));

    }

    @Test
    void test02() {
        Node<Double> a = new Node<>(-1.);
        Node<Double> b = new Node<>(-6.);
        Node<Double> c = new Node<>(-5.);
        Node<Double> d = new Node<>(-3.);
        Node<Double> e = new Node<>(0.);
        Node<Double> f = new Node<>(-13.);
        Node<Double> g = new Node<>(-1.);
        Node<Double> h = new Node<>(-2.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

        //        -1
        //      /   \
        //    -6    -5
        //   /  \     \
        // -3   0    -13
        //     /       \
        //    -1       -2

        assertEquals(8D, MaxRooToLeafPathSum.maxPathSum(a));
    }

    @Test
    void test03() {
        Node<Double> a = new Node<>(42.);
        //42
        assertEquals(42D, MaxRooToLeafPathSum.maxPathSum(a));
    }
}
