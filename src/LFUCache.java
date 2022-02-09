import java.util.Map;
import java.util.PriorityQueue;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 * When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie
 * (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is
 * called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[4,3], cnt(4)=2, cnt(3)=3
 *
 *
 * Constraints:
 *
 * 0 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * At most 2 * 105 calls will be made to get and put.
 */
import java.util.*;
public class LFUCache {
    int time;
    Map<Integer, Item> map;
    PriorityQueue<Item> pq;
    int capacity;
    int size;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        this.map = new HashMap<>();
        this.size = 0;
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.count == o2.count) {
                    return o1.time - o2.time;
                }
                return o1.count - o2.count;
            }
        };
        pq = new PriorityQueue<>(comparator);
    }

    public int get(int key) {
        if(this.map.size() == 0 || map.get(key) == null) {
            return -1;
        }
        this.time++;
        Item item = map.get(key);
        pq.remove(item);
        item.time = time;
        item.count++;
        pq.offer(item);
        return item.value;
    }

    public void put(int key, int value) {
        this.time++;
        if(map.containsKey(key)) {
            Item item = map.get(key);
            pq.remove(item);
            item.time = this.time;
            item.count++;
            item.value = value;
            pq.offer(item);
        } else {
            size++;
            Item item = new Item();
            item.value = value;
            item.key = key;
            item.count = 1;
            item.time = this.time;

            if(this.size > capacity) {
                if(!pq.isEmpty()) {
                    Item temp = pq.poll();
                    map.remove(temp.key);
                    size--;
                }
            }
            if(this.capacity != 0) {
                map.put(key, item);
                pq.offer(item);
            }
        }
    }
    class Item {
        int key;
        int value;
        int time;
        int count;
    }
}
