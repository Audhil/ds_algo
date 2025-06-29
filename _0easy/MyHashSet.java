package _0easy;

//  https://www.youtube.com/watch?v=NrMaQL_4Npo
//  design my own hash set, without using any available hash table apis

//  approach 1 - time complexity - O(1) & space complexity - O(n)
//public class MyHashSet {
//    private final int MAX_VALUE = 100000;
//    private boolean[] myArr;
//
//    public MyHashSet() {
//        myArr = new boolean[MAX_VALUE];
//    }
//
//    private void add(int key) {
//        myArr[key] = true;
//    }
//
//    private boolean contains(int key) {
//        return myArr[key];
//    }
//
//    private void remove(int key) {
//        myArr[key] = false;
//    }
//
//    public static void main(String[] args) {
//        MyHashSet set = new MyHashSet();
//        set.add(8);
//        System.out.println("yup: is it : " + set.contains(8));
//        set.remove(8);
//        System.out.println("yup: is it : " + set.contains(8));
//    }
//}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//  approach 2
public class MyHashSet {
    private final int ARR_SIZE = 100;
    private final List<List<Integer>> bucketList;

    public MyHashSet() {
        bucketList = new ArrayList<>(ARR_SIZE);
        for (int i = 0; i < ARR_SIZE; i++) {
            bucketList.add(null);
        }
    }

    private void add(int key) {
        int index = key % ARR_SIZE;
        List<Integer> childList = bucketList.get(index);

        if (childList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            bucketList.set(index, list);
        } else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    private void remove(int key) {
        int index = key % ARR_SIZE;
        List<Integer> childList = bucketList.get(index);
        if (childList != null) {
            //  https://youtu.be/NrMaQL_4Npo?t=1295
            childList.remove(Integer.valueOf(key));
        }
    }

    private boolean contains(int key) {
        int index = key % ARR_SIZE;
        List<Integer> childList = bucketList.get(index);
        return childList != null && childList.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(8);
        System.out.println("yup: is it : " + set.contains(8));
        set.remove(8);
        System.out.println("yup: is it : " + set.contains(8));
    }
}
