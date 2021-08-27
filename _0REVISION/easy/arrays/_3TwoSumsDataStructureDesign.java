package _0REVISION.easy.arrays;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/two-sum-iii-data-structure-design/
//  https://www.lintcode.com/problem/607/discuss/2800
public class _3TwoSumsDataStructureDesign {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void add(int number) {
        if (!map.containsKey(number))
            map.put(number, 0);
        map.put(number, map.get(number) + 1);
    }

    public static boolean find(int value) {
        for (Integer key : map.keySet()) {
            int num1 = key;
            int num2 = value - key;
            if ((num1 == num2 && map.get(num2) > 1)
                    || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        add(1);
        add(3);
        add(3);
        add(5);

        System.out.println(find(4));    //  true
        System.out.println(find(7));    //  false
        System.out.println(find(6));    //  true
    }
}
