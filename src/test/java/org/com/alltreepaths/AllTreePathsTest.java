package org.com.alltreepaths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllTreePathsTest {

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

        List<List<String>> actual = AllTreePaths.allTreePaths(a); // ->
        List<List<String>> expected = List.of(List.of("a", "b", "d"), List.of("a", "b", "e"), List.of("a", "c", "f"));
        assertSameSizeAndSameInner(actual, expected);
// [
//   [ 'a', 'b', 'd' ],
//   [ 'a', 'b', 'e' ],
//   [ 'a', 'c', 'f' ]
// ]
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
        Node<String> i = new Node<>("i");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;
        f.left = i;

//         a
//      /    \
//     b      c
//   /  \      \
//  d    e      f
//      / \    /
//     g  h   i


        List<List<String>> actual = AllTreePaths.allTreePaths(a); // ->
        List<List<String>> expected = List.of(List.of("a", "b", "d"), List.of("a", "b", "e", "g"),
                List.of("a", "b", "e", "h"), List.of("a", "c", "f", "i"));
        assertSameSizeAndSameInner(actual, expected);
// [
//   [ 'a', 'b', 'd' ],
//   [ 'a', 'b', 'e', 'g' ],
//   [ 'a', 'b', 'e', 'h' ],
//   [ 'a', 'c', 'f', 'i' ]
// ]
    }

    @Test
    void test02() {
        Node<String> q = new Node<>("q");
        Node<String> r = new Node<>("r");
        Node<String> s = new Node<>("s");
        Node<String> t = new Node<>("t");
        Node<String> u = new Node<>("u");
        Node<String> v = new Node<>("v");

        q.left = r;
        q.right = s;
        r.right = t;
        t.left = u;
        u.right = v;

//      q
//    /   \
//   r     s
//    \
//     t
//    /
//   u
//  /
// v


        List<List<String>> actual = AllTreePaths.allTreePaths(q); // ->
        List<List<String>> expected = List.of(List.of("q","r","t","u","v"),List.of("q","s"));
        assertSameSizeAndSameInner(actual, expected);
// [
//   [ 'q', 'r', 't', 'u', 'v' ],
//   [ 'q', 's' ]
// ]
    }

    @Test
    void test03() {
        Node<String> z = new Node<>("z");

//      z

        List<List<String>> actual = AllTreePaths.allTreePaths(z); // ->
        List<List<String>> expected = List.of(List.of("z"));
        assertSameSizeAndSameInner(actual, expected);
// [
//   ['z']
// ]
    }

    public void assertSameSizeAndSameInner(List<List<String>> actual, List<List<String>> expected) {
        Assertions.assertEquals(actual.size(), expected.size());
        ArrayList actualList = new ArrayList(actual);
        ArrayList expectedList = new ArrayList(expected);
        Collections.sort(actualList, new ListLastElementCompare());
        Collections.sort(expectedList, new ListLastElementCompare());
        for (int i = 0; i < actualList.size(); i++) {
            Assertions.assertEquals(actualList.get(i), expectedList.get(i));
        }
    }

    class ListLastElementCompare implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            return o1.get(o1.size() - 1).compareTo(o2.get(o2.size() - 1));
        }
    }

}
