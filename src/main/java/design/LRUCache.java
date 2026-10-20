package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private int capacity;

    class Node {
        private Node prev;
        private Node next;
        private K key;
        private V value;
    }

    // Eager initialization
    private Map<K,Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Empty nodes
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if(!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);

        if (moveToTop(node)) return node.value;

        return node.value;
    }

    private boolean moveToTop(Node node) {
        //move to top
        Node first = head.next;
        if(first == node) {
            //already at top and head.next = node.
            return true;
        }

        // what if node at center or last node.
        if(node.prev != null) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
        }

        first.prev = node;
        node.next = first;
        node.prev = head;
        head.next = node;
        return false;
    }


    public void put(K key, V value) {
        // map already have key
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            moveToTop(node);
        } else {
            Node node = new Node();

            node.key = key;
            node.value = value;

            Node first = head.next;
            first.prev = node;
            node.next = first;
            node.prev = head;
            head.next = node;
            map.put(key, node);
        }

        if(map.size() > capacity) {
            // Remove last node

            Node last = tail.prev;
            System.out.println("removing " + last.key + " with value " + last.value);
            map.remove(last.key);

            last.prev.next = tail;
            tail.prev = last.prev;
            last.prev = null;
            last.next = null;
        }
    }


    public static void main(String[] args) {

        // ============================================================
        // TEST 1: Basic put() and get()
        // ============================================================
        System.out.println("TEST 1: Basic put/get");

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache.get(1)); // Expected: A
        System.out.println(cache.get(2)); // Expected: B
        System.out.println(cache.get(3)); // Expected: C


        // ============================================================
        // TEST 2: Missing key
        // ============================================================
        System.out.println("\nTEST 2: Missing key");

        System.out.println(cache.get(99)); // Expected: null


        // ============================================================
        // TEST 3: Updating an existing key
        // ============================================================
        System.out.println("\nTEST 3: Update existing key");

        cache.put(2, "B-UPDATED");

        System.out.println(cache.get(2)); // Expected: B-UPDATED


        // ============================================================
        // TEST 4: LRU eviction
        // ============================================================
        System.out.println("\nTEST 4: LRU eviction");

        LRUCache<Integer, String> cache2 = new LRUCache<>(3);

        cache2.put(1, "A");
        cache2.put(2, "B");
        cache2.put(3, "C");

        // Order should be:
        // HEAD -> 3 -> 2 -> 1 -> TAIL

        cache2.put(4, "D");

        // 1 should be evicted
        System.out.println(cache2.get(1)); // Expected: null

        System.out.println(cache2.get(2)); // Expected: B
        System.out.println(cache2.get(3)); // Expected: C
        System.out.println(cache2.get(4)); // Expected: D


        // ============================================================
        // TEST 5: get() changes LRU order
        // ============================================================
        System.out.println("\nTEST 5: get() changes LRU order");

        LRUCache<Integer, String> cache3 = new LRUCache<>(3);

        cache3.put(1, "A");
        cache3.put(2, "B");
        cache3.put(3, "C");

        // Current:
        // HEAD -> 3 -> 2 -> 1 -> TAIL

        cache3.get(1);

        // Now:
        // HEAD -> 1(A) -> 3 -> 2 -> TAIL

        cache3.put(4, "D");

        // 2 should be evicted
        System.out.println(cache3.get(2)); // Expected: null

        System.out.println(cache3.get(1)); // Expected: A
        System.out.println(cache3.get(3)); // Expected: C
        System.out.println(cache3.get(4)); // Expected: D


        // ============================================================
        // TEST 6: Update existing key changes its LRU position
        // ============================================================
        System.out.println("\nTEST 6: Update changes LRU order");

        LRUCache<Integer, String> cache4 = new LRUCache<>(3);

        cache4.put(1, "A");
        cache4.put(2, "B");
        cache4.put(3, "C");

        // HEAD -> 3 -> 2 -> 1 -> TAIL

        cache4.put(1, "A-UPDATED");

        // HEAD -> 1 -> 3 -> 2 -> TAIL

        cache4.put(4, "D");

        // 2 should be evicted

        System.out.println(cache4.get(1)); // Expected: A-UPDATED
        System.out.println(cache4.get(2)); // Expected: null
        System.out.println(cache4.get(3)); // Expected: C
        System.out.println(cache4.get(4)); // Expected: D


        // ============================================================
        // TEST 7: Capacity = 1
        // ============================================================
        System.out.println("\nTEST 7: Capacity = 1");

        LRUCache<Integer, String> cache5 = new LRUCache<>(1);

        cache5.put(1, "A");
        System.out.println(cache5.get(1)); // Expected: A

        cache5.put(2, "B");

        System.out.println(cache5.get(1)); // Expected: null
        System.out.println(cache5.get(2)); // Expected: B


        // ============================================================
        // TEST 8: Repeated get()
        // ============================================================
        System.out.println("\nTEST 8: Repeated get()");

        LRUCache<Integer, String> cache6 = new LRUCache<>(3);

        cache6.put(1, "A");
        cache6.put(2, "B");
        cache6.put(3, "C");

        System.out.println(cache6.get(3)); // Expected: C
        System.out.println(cache6.get(3)); // Expected: C
        System.out.println(cache6.get(3)); // Expected: C

        cache6.put(4, "D");

        // 1 should be evicted
        System.out.println(cache6.get(1)); // Expected: null


        // ============================================================
        // TEST 9: Null key
        // ============================================================
        System.out.println("\nTEST 9: Null key");

        LRUCache<Integer, String> cache7 = new LRUCache<>(2);

        cache7.put(null, "NULL");

        System.out.println(cache7.get(null)); // Expected: NULL


        // ============================================================
        // TEST 10: Null value
        // ============================================================
        System.out.println("\nTEST 10: Null value");

        LRUCache<Integer, String> cache8 = new LRUCache<>(2);

        cache8.put(1, null);

        System.out.println(cache8.get(1)); // Expected: null


        // ============================================================
        // TEST 11: Multiple evictions
        // ============================================================
        System.out.println("\nTEST 11: Multiple evictions");

        LRUCache<Integer, String> cache9 = new LRUCache<>(2);

        cache9.put(1, "A");
        cache9.put(2, "B");
        cache9.put(3, "C");
        cache9.put(4, "D");

        // Expected:
        // 1 -> evicted
        // 2 -> evicted
        // 3 -> present
        // 4 -> present

        System.out.println(cache9.get(1)); // Expected: null
        System.out.println(cache9.get(2)); // Expected: null
        System.out.println(cache9.get(3)); // Expected: C
        System.out.println(cache9.get(4)); // Expected: D


        // ============================================================
        // TEST 12: Capacity = 0
        // ============================================================
        System.out.println("\nTEST 12: Capacity = 0");

        LRUCache<Integer, String> cache10 = new LRUCache<>(0);

        cache10.put(1, "A");

        System.out.println(cache10.get(1)); // Expected: null
    }



}
