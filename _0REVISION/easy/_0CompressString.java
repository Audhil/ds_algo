package _0REVISION.easy;

//  https://www.youtube.com/watch?v=cMnsDhzvf2E
public class _0CompressString {

    private static String compressed(String input) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                builder.append(input.charAt(i));
                builder.append(count);
                count = 0;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("the compressed string: "+compressed("aaAAAzddddddGHHHm"));  //  the compressed string: a2A3z1d6G1H3m1
    }
}
