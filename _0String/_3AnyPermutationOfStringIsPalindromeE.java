package _0String;

import java.util.HashSet;
import java.util.Set;

//  https://www.interviewcake.com/question/python/permutation-palindrome?utm_source=weekly_email&utm_source=drip&utm_campaign=weekly_email&utm_campaign=Interview%20Cake%20Weekly%20Problem%20%23429:%20Permutation%20Palindrome&utm_medium=email&utm_medium=email
/*
* Interview Cake
Interview Tips
Glossary
Full Course
Get the full course
Log in to save progress
You're out of free questions.

Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome. ↴

You can assume the input string only contains lowercase letters.

Examples:

"civic" should return True
"ivicc" should return True
"civil" should return False
"livci" should return False
"But 'ivicc' isn't a palindrome!"

If you had this thought, read the question again carefully. We're asking if any permutation of the string is a palindrome. Spend some extra time ensuring you fully understand the question before starting. Jumping in with a flawed understanding of the problem doesn't look good in an interview.

Gotchas
We can do this in O(n)O(n) time.

Breakdown
The brute force ↴ approach would be to check every permutation of the input string to see if it is a palindrome.

What would be the time cost?

We'd have to generate every permutation of the input string. If the string has nn characters, then there are nn choices for the first character, n - 1n−1 choices for the second character, and so on. In total, that's n!n! permutations.
We'd have to check each permutation to see if it's a palindrome. That takes O(n)O(n) time per permutation, since each permutation is nn letters.
Together, that's O(n! * n)O(n!∗n) time. Yikes! We can do better.

Let's try rephrasing the problem. How can we tell if any permutation of a string is a palindrome?

Well, how would we check that a string is a palindrome? We could use the somewhat-common "keep two pointers" pattern. We'd start a pointer at the beginning of the string and a pointer at the end of the string, and check that the characters at those pointers are equal as we walk both pointers towards the middle of the string.
  civic
^   ^

civic
 ^ ^

civic
  ^
Can we adapt the idea behind this approach to checking if any permutation of a string is a palindrome?

Notice: we're essentially checking that each character left of the middle has a corresponding copy right of the middle.

We can simply check that each character appears an even number of times (unless there is a middle character, which can appear once or some other odd number of times). This ensures that the characters can be ordered so that each char on the left side of the string has a matching char on the right side of the string.

But we'll need a data structure to keep track of the number of times each character appears. What should we use?

We could use a dictionary ↴ . (Tip: using a dictionary is the most common way to get from a brute force approach to something more clever. It should always be your first thought.)

So we’ll go through all the characters and track how many times each character appears in the input string. Then we just have to make sure no more than one of the characters appears an odd numbers of times.

That will give us a runtime of O(n)O(n), which is the best we can do since we have to look at a number of characters dependent on the length of the input string.

Ok, so we’ve reached our best run time. But can we still clean our solution up a little?

We don’t really care how many times a character appears in the string, we just need to know whether the character appears an even or odd number of times.

What if we just track whether or not each character appears an odd number of times? Then we can map characters to booleans. This will be more explicit (we don’t have to check each number’s parity, we already have booleans) and we’ll avoid the risk of integer overflow ↴ if some characters appear a high number of times.

Can we take this a step further and clean it up even more?

Even more specifically than whether characters appear an even or odd number of times, we really just need to know there isn’t more than one character that appears an odd number of times.

What if we only track the characters that appear an odd number of times? Is there a data structure even simpler than a dictionary we could use?

We could use a set, adding and removing characters as we look through the input string, so the set always only holds the characters that appear an odd number of times.

Solution
Our approach is to check that each character appears an even number of times, allowing for only one character to appear an odd number of times (a middle character). This is enough to determine if a permutation of the input string is a palindrome.

We iterate through each character in the input string, keeping track of the characters we’ve seen an odd number of times using a set unpaired_characters.

As we iterate through the characters in the input string:

If the character is not in unpaired_characters, we add it.
If the character is already in unpaired_characters, we remove it.
Finally, we just need to check if less than two characters don’t have a pair.

  def has_palindrome_permutation(the_string):
    # Track characters we've seen an odd number of times
    unpaired_characters = set()

    for char in the_string:
        if char in unpaired_characters:
            unpaired_characters.remove(char)
        else:
            unpaired_characters.add(char)

    # The string has a palindrome permutation if it
    # has one or zero characters without a pair
    return len(unpaired_characters) <= 1

Python 2.7
Complexity
O(n)O(n) time, since we're making one iteration through the nn characters in the string.

Our unpaired_characters set is the only thing taking up non-constant space. We could say our space cost is O(n)O(n) as well, since the set of unique characters is less than or equal to nn. But we can also look at it this way: there are only so many different characters. How many? The ASCII character set has just 128 different characters (standard english letters and punctuation), while Unicode has 110,000 (supporting several languages and some icons/symbols). We might want to treat our number of possible characters in our character set as another variable kk and say our space complexity is O(k)O(k). Or we might want to just treat it as a constant, and say our space complexity is O(1)O(1).

What We Learned
One of the tricks was to use a dictionary or set.

This is the most common way to get from a brute force approach to something more efficient. Especially for easier problems.

I even know interviewers who just want to hear you say "dictionary", and once they hear that they'll say, "Great, let's move on."

So always ask yourself, right from the start: "Can I save time by using a dictionary?"
* */
public class _3AnyPermutationOfStringIsPalindromeE {

  //  TC: O (n); // SC: O (n)
  private static boolean isAnyPermutationIsPalindrome(String str) {
    Set<Character> set = new HashSet<>();
    for (char ch : str.toCharArray()) {
      if (!set.add(ch)) {
        set.remove(ch);
      }
    }
    return set.size() <= 1;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: isAnyPermutationIsPalindrome: " + isAnyPermutationIsPalindrome(
            "civic")); //  yup: isAnyPermutationIsPalindrome: true
    System.out.println(
        "yup: isAnyPermutationIsPalindrome: " + isAnyPermutationIsPalindrome(
            "ivicc")); //  yup: isAnyPermutationIsPalindrome: true
    System.out.println(
        "yup: isAnyPermutationIsPalindrome: " + isAnyPermutationIsPalindrome(
            "civil")); //  yup: isAnyPermutationIsPalindrome: false
    System.out.println(
        "yup: isAnyPermutationIsPalindrome: " + isAnyPermutationIsPalindrome(
            "livci")); //  yup: isAnyPermutationIsPalindrome: false
  }
}
