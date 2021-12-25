package dataStructure2_1.day02;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 提示：
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains
 *
 * @author xinchan
 * @version 1.0.1 2021-12-25
 */
public class MyHashSet {
    public static void main(String[] args) {
        /*
         * 测试 MyHashSet class
         */
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

    /*
     * instance field
     */
    private static final int BASE = 769;
    private LinkedList<Integer>[] array;

    public MyHashSet() {
        this.array = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hashValue = hash(key);
        for (int e : array[hashValue]) {
            if (e == key) {
                return;
            }
        }

        array[hashValue].add(key);
    }

    public void remove(int key) {
        int hashValue = hash(key);
        array[hashValue].remove((Integer) key);
    }

    public boolean contains(int key) {
        int hashValue = hash(key);
        for (int e : array[hashValue]) {
            if (e == key) {
                return true;
            }
        }
        return false;
    }

    public int hash(int key) {
        return key % BASE;
    }
}
