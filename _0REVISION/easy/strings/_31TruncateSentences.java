package _0REVISION.easy.strings;

//  https://leetcode.com/problems/truncate-sentence/submissions/
public class _31TruncateSentences {

    public static String truncateSentence(String s, int k) {
        if (s == null || k < 0)
            return null;

        StringBuilder sBuilder = new StringBuilder();
        for (String str : s.split(" ")) {
            if (k == 0)
                break;
            sBuilder.append(str);
            sBuilder.append(" ");
            k--;
        }
        return sBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("yup: " + truncateSentence("Hello how are you Contestant", 2));
    }
}
