package _0REVISION.easy.arrays;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/count-items-matching-a-rule/
/*
* You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.



Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
Example 2:

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.

 * */
public class _17CountItemMatching {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0, count = 0;
        if (ruleKey.equalsIgnoreCase("color"))
            index = 1;
        else if (ruleKey.equalsIgnoreCase("name"))
            index = 2;
        for (List<String> item : items) {
            if (ruleValue.equalsIgnoreCase(item.get(index)))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<String> item = new ArrayList<>();
            if (i == 0) {
                item.add("phone");
                item.add("blue");
                item.add("pixel");
            } else if (i == 1) {
                item.add("computer");
                item.add("silver");
                item.add("lenovo");
            } else {
                item.add("phone");
                item.add("gold");
                item.add("iphone");
            }
            items.add(item);
        }
        System.out.println("yup: _17CountItemMatching: " + countMatches(items, "color", "silver"));
        System.out.println("yup: _17CountItemMatching: " + countMatches(items, "type", "phone"));
    }
}
