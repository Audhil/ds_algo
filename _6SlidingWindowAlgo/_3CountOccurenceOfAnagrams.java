package _6SlidingWindowAlgo;

import java.util.HashMap;
import java.util.Map;

//  https://youtu.be/MW4lJ8Y0xXk?list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj
public class _3CountOccurenceOfAnagrams {

//    private String word = "forxxorfxdofr";
//    private String pattern = "for";

    private String word = "aabaabaa";
    private String pattern = "aaba";
    
    private int k = pattern.length();   //  size of window is size of pattern
    private int size = word.length();

    private int countOfOccurenceOfAnagrams() {
        int ans = 0;
        int i = 0, j = 0;
        Map<Character, Integer> hMap = new HashMap<>();
        for (int l = 0; l < pattern.length(); l++) {
            if (hMap.get(pattern.charAt(l)) == null)
                hMap.put(pattern.charAt(l), 1);
            else
                hMap.put(pattern.charAt(l), hMap.get(pattern.charAt(l)) + 1);
        }
        int count = hMap.size();
        while (j < size) {
            //  calculations
            if (hMap.containsKey(word.charAt(j))
                    && hMap.get(word.charAt(j)) > 0)
                hMap.put(word.charAt(j), hMap.get(word.charAt(j)) - 1);
            //  is count reached
            if (hMap.containsKey(word.charAt(j))
                    && hMap.get(word.charAt(j)) == 0)
                count--;
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                //  get the ans
                if (count == 0)  //  if both chars are available in the window
                    ans++;

                //  slide the window
                if (hMap.containsKey(word.charAt(i))) {
                    hMap.put(word.charAt(i), hMap.get(word.charAt(i)) + 1);
                    count++;
                }

                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _3CountOccurenceOfAnagrams prob = new _3CountOccurenceOfAnagrams();
        System.out.println("yup: count of occurence of anagrams : " + prob.countOfOccurenceOfAnagrams());
    }
}
