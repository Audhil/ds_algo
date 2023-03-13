//package _6SlidingWindowAlgo._neetcode;
//
//public class _9AlterAI_Interview {
//
//  Given two strings, find the length of the smallest substring of the first string containing all the characters of the second string.
//      EABBADDCAEAF, DAE -> 4
//
//  example:
//  XXXADDDDDDDDFFDEXXXX
//      DDDAAEEEADDADDEEADDDAAADEEEAADAA
//
//
////	java - TC: O (n)
//  Private int lengthOfSmallestSubstring(String input, String substring){
//    Int left = 0, right = 0;
//
//    //	make the count map
//    Map<Character, Integer> countMap = new HashMap<>();
//    for(char ch: substring.toCharArray()){
//      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
//    }
//
////	iterate input string
//    Int lenOfInput = input.length();
//
//    Map<Character, Integer> inputCountMap = new HashMap<>();
//    Int counter = 0; int windowSize = Integer.MAX_VALUE;
//
//    while(right < lenOfInput){
//      Char charAtR = input.charAt(right);
//      inputCountMap.put(charAtR, countMap.getOrDefault(charAtR, 0) + 1);
//
//      if(countMap.containKey(charAtR)){
//        if(countMap.get(charAtR) == inputCountMap.get(charAtR)){
//          Counter++;
//        }
//      }
//      while(counter == countMap.size()){
//        windowSize = Math.min(windowSize, (right - left) + 1);
//        Char charAtL = input.charAt(left);
//        inputCountMap.put(charAtL, inputCountMap.getOrDefault(charAtL, 0)-1);
//        if(countMap.containKey(charAtL)) && inputCountMap.get(charAtL) == 0){
//          Counter–;
//        }
//        Left++;
//      }
//      right++;
//    }
//    Return windowSize;
//  }
//
//
//if map contains all the required characters -> then left++
//      if map does NOT contain all the required characters -> then right++
//
//}
