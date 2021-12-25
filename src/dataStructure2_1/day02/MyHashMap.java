package dataStructure2_1.day02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 706. 设计哈希映射
 * 提示：
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 *
 * @author xinchan
 * @version 1.0.1 2021-12-25
 */
public class MyHashMap {
    public static void main(String[] args) {
        /*
         * 测试 MyHashMap class
         */
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

    /*
     * instance field
     */
    private static final int BASE = 769;
    private LinkedList<int[]>[] array;

    public MyHashMap() {
        this.array = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hashValue = hash(key);
        for (int[] e : array[hashValue]) {
            if (e[0] == key) {
                e[1] = value;
            }
        }
        array[hashValue].add(new int[]{key, value});
    }

    public int get(int key) {
        int hashValue = hash(key);
        for (int[] e : array[hashValue]) {
            if (e[0] == key) {
                return e[1];
            }
        }

        return -1;
    }

    public void remove(int key) {
        int hashValue = hash(key);
        array[hashValue].removeIf(e -> e[0] == key);
    }

    private int hash(int key) {
        return key % BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */